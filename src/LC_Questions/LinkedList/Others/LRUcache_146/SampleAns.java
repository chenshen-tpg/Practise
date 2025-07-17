package LC_Questions.LinkedList.Others.LRUcache_146;

public class SampleAns {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    public Node[] map;
    public int count, capacity;
    public Node head, tail;
    public SampleAns(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new Node[10001];
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(Node node) {
        node.next = this.head.next;
        node.prev = this.head;
        node.next.prev = node;
        this.head.next = node;
    }
    public int get(int key) {
        if(map[key] != null) {
            Node node = map[key];
            deleteNode(node);
            addToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    public void put(int key, int value) {
        if (map[key] != null) {
            Node node = map[key];
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map[key] = node;
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                Node least = tail.prev;
                map[least.key] = null;
                deleteNode(least);
                addToHead(node);
            }
        }
    }
}
