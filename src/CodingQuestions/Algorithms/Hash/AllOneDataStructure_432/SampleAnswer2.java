package CodingQuestions.Algorithms.Hash.AllOneDataStructure_432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SampleAnswer2 {

    public static class Node {
        int freq;
        Set<String> keys;
        Node prev;
        Node next;

        public Node(int freq, Node prev, Node next) {
            this.freq = freq;
            this.keys = new HashSet<>();
            this.prev = prev;
            this.next = next;
        }
    }

    HashMap<String, Node> hm;
    Node head;
    Node tail;

    public static void main(String[] args) {
        String[] operations = {"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"};
        Object[][] inputs = {
                {},
                {"hello"},
                {"hello"},
                {},
                {},
                {"leet"},
                {},
                {}
        };

        SampleAnswer2 allOne = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "AllOne":
                    allOne = new SampleAnswer2();
                    System.out.println("AllOne initialized");
                    break;
                case "inc":
                    allOne.inc((String) inputs[i][0]);
                    System.out.println("inc(" + inputs[i][0] + ")");
                    break;
                case "dec":
                    allOne.dec((String) inputs[i][0]);
                    System.out.println("dec(" + inputs[i][0] + ")");
                    break;
                case "getMaxKey":
                    System.out.println("getMaxKey() -> " + allOne.getMaxKey());
                    break;
                case "getMinKey":
                    System.out.println("getMinKey() -> " + allOne.getMinKey());
                    break;
            }
        }
    }
    public SampleAnswer2() {
        hm = new HashMap<>();
        tail = new Node(0, null, null);
        head = new Node(Integer.MAX_VALUE, null, null);
        tail.next = head;
        head.prev = tail;
    }

    public void inc(String key) {
        Node curNode = hm.containsKey(key) ? hm.get(key) : tail;
        Node nextNode = curNode.next;
        int curFreq = curNode.freq;
        if (curNode.next.freq != curFreq + 1) {
            Node node = new Node(curFreq + 1, curNode, nextNode);
            curNode.next = node;
            nextNode.prev = node;
        }
        if (curNode != tail) {
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                Node prev = curNode.prev;
                Node next = curNode.next;
                prev.next = next;
                next.prev = prev;
            }
        }
        curNode.next.keys.add(key);
        hm.put(key, curNode.next);
    }

    public void dec(String key) {
        Node curNode = hm.get(key);
        Node prevNode = curNode.prev;
        int curFreq = curNode.freq;
        if (prevNode.freq != curFreq - 1) {
            Node node = new Node(curFreq - 1, prevNode, curNode);
            curNode.prev = node;
            prevNode.next = node;
        }

        if (curNode.prev != tail) {
            curNode.prev.keys.add(key);
            hm.put(key, curNode.prev);
        } else {
            hm.remove(key);
        }
        curNode.keys.remove(key);
        if (curNode.keys.isEmpty()) {
            Node prev = curNode.prev;
            Node next = curNode.next;

            prev.next = next;
            next.prev = prev;
        }
    }

    public String getMaxKey() {
        if (head.prev == tail) {
            return "";
        }
        return head.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (tail.next == head) {
            return "";
        }
        return tail.next.keys.iterator().next();
    }

}
