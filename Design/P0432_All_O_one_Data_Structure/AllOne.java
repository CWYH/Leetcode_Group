import java.util.*;

/**
 * 432. All O`one Data Structure -- Hard
 */

class AllOne {

    private class Node {
        int val;
        HashSet<String> keys;
        Node pre;
        Node next;
        Node(int val) {
            this.val = val;
            keys = new HashSet<>();
            pre = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private HashMap<String, Node> keyMap;
    private HashMap<Integer, Node> valMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        keyMap = new HashMap<>();
        valMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node cur = keyMap.get(key);
            keyMap.remove(key);
            int val = cur.val + 1;
            cur.keys.remove(key);
            if (valMap.containsKey(val)) {
                Node target = valMap.get(val);
                target.keys.add(key);
                keyMap.put(key, target);
                valMap.put(val, target);    // ??
            } else {
                insertNode(cur, key, val);
            }

            if (cur.keys.isEmpty()) {
                valMap.remove(cur.val);
                deleteNode(cur);
            }
        } else {
            if (valMap.containsKey(1)) {
                Node target = valMap.get(1);
                target.keys.add(key);
                keyMap.put(key, target);
                valMap.put(1, target);
            } else {
                insertNode(head, key, 1);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            Node cur = keyMap.get(key);
            keyMap.remove(key);
            int val = cur.val - 1;
            cur.keys.remove(key);
            if (val > 0) {
                if (valMap.containsKey(val)) {
                    Node target = valMap.get(val);
                    target.keys.add(key);
                    keyMap.put(key, target);
                    valMap.put(val, target);    // ??
                } else {
                    insertNode(cur.pre, key, val);
                }
            }

            if (cur.keys.isEmpty()) {
                valMap.remove(cur.val);
                deleteNode(cur);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head.next == tail ? "" : (String)tail.pre.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String)head.next.keys.iterator().next();
    }

    private void insertNode(Node node, String key, int val) {
        Node newNode = new Node(val);
        newNode.keys.add(key);
        newNode.pre = node;
        newNode.next = node.next;
        node.next = newNode;
        newNode.next.pre = newNode;
        keyMap.put(key, newNode);
        valMap.put(val, newNode);
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public static void main(String[] args) {
        AllOne al = new AllOne();
        al.inc("hello");
        al.inc("goodbye");
        al.inc("hello");
        al.inc("hello");
        System.out.println(al.getMaxKey());
        al.inc("leet");
        al.inc("code");
        al.inc("leet");
        al.dec("hello");
        al.inc("leet");
        al.inc("code");
        al.inc("code");
        System.out.println(al.getMaxKey());
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */