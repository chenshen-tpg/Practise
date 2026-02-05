package Concept.General.CoreConcepts.ConsistentHashing;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Objects;


//Apache Cassandra: Uses consistent hashing to distribute data across the ring
//Amazon's DynamoDB: Uses consistent hashing under the hood
//Content Delivery Networks (CDNs): Use consistent hashing to determine which edge server should cache specific content

public class ConsistentHash {
    private final SortedMap<Integer, String> hashRing = new TreeMap<>();
    private final Set<String> physicalNodes = new HashSet<>();
    private final HashFunction hashFunction;
    private final int numberOfReplicas;

    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
    }


    /**
     * Represents a physical server node in the distributed system.
     */
    public static class Node {
        private final String id; // A unique identifier for the node (e.g., "server-1", "cache-a")
        private final String hostname;
        private final int port;

        public Node(String id, String hostname, int port) {
            this.id = Objects.requireNonNull(id);
            this.hostname = Objects.requireNonNull(hostname);
            this.port = port;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id='" + id + '\'' +
                    ", hostname='" + hostname + '\'' +
                    ", port=" + port +
                    '}';
        }
    }

    /**
     * Adds a physical node to the hash ring with a specified number of replicas.
     *
     * @param node The physical node to add.
     */
    public void addNode(Node node) {
        if (!physicalNodes.add(node.getId())) {
            System.out.println("Node with ID " + node.getId() + " already exists.");
            return;
        }
        for (int i = 0; i < numberOfReplicas; i++) {
            // Create unique virtual node identifiers for each replica
            String virtualNodeId = node.getId() + "#" + i;
            int hash = hashFunction.hash(virtualNodeId);
            hashRing.put(hash, node.getId());
        }
    }

    /**
     * Removes a physical node and all its virtual replicas from the hash ring.
     *
     * @param node The physical node to remove.
     */
    public void removeNode(Node node) {
        if (!physicalNodes.remove(node.getId())) {
            System.out.println("Node with ID " + node.getId() + " not found.");
            return;
        }
        for (int i = 0; i < numberOfReplicas; i++) {
            String virtualNodeId = node.getId() + "#" + i;
            int hash = hashFunction.hash(virtualNodeId);
            hashRing.remove(hash);
        }
    }

    /**
     * Gets the ID of the physical node responsible for a given key.
     *
     * @param key The key to map to a node.
     * @return The ID of the physical node, or null if the ring is empty.
     */
    public String getNode(String key) {
        if (hashRing.isEmpty()) {
            return null;
        }
        int keyHash = hashFunction.hash(key);
        // Find the first virtual node with a hash greater than or equal to the key's hash
        SortedMap<Integer, String> tailMap = hashRing.tailMap(keyHash);
        if (tailMap.isEmpty()) {
            // Wrap around the ring to get the first node
            return hashRing.get(hashRing.firstKey());
        } else {
            return tailMap.get(tailMap.firstKey());
        }
    }

    /**
     * A simple, custom hash function interface.
     */
    @FunctionalInterface
    public interface HashFunction {
        int hash(String value);
    }
}

