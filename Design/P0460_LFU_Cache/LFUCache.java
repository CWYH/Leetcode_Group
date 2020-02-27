import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU Cache -- Hard
 */

// class LFUCache {

//     private class Node {
//         int key;
//         int val;
//         int cnt;   // count of times being used
//         Node pre;
//         Node next;
//         Node(int key, int val) {
//             this.key = key;
//             this.val = val;
//             this.cnt = 0;
//             pre = null;
//             next = null;
//         }
//     }

//     private Node head = new Node(-1, -1);
//     private Node tail = new Node(-1, -1);
//     private int size = 0;
//     private int capacity = 0;
//     private HashMap<Integer, Node> mruMap = new HashMap<>();    // cnt -> most recent used (mru) Node
//     private HashMap<Integer, Node> lruMap = new HashMap<>();    // key -> lru Node
//     private HashMap<Integer, Node> keyMap = new HashMap<>();

//     public LFUCache(int capacity) {
//         this.capacity = capacity;
//         head.next = tail;
//         tail.pre = head;
//     }

//     public int get(int key) {
//         if (!keyMap.containsKey(key)) return -1;
//         Node node = keyMap.get(key);
//         keyMap.remove(key);
//         int val = node.val;
//         int cnt = node.cnt;
//         cnt++;
//         if (mruMap.containsKey(cnt)) {
//             Node p = mruMap.get(cnt);
//             insertNode(p, key, val, cnt);
//             mruMap.put(cnt, p.next);
//             keyMap.put(key, p.next);
//         } else {
//             Node p = mruMap.get(node.cnt);
//             insertNode(p, key, val, cnt);
//             mruMap.put(cnt, p.next);
//             lruMap.put(cnt, p.next);
//             keyMap.put(key, p.next);
//         }

//         cnt--;
//         if (mruMap.get(cnt) == node && lruMap.get(cnt) == node) { // node is mru and lru
//             mruMap.remove(cnt);
//             lruMap.remove(cnt);
//         } else if (mruMap.get(cnt) == node && lruMap.get(cnt) != node) {
//             mruMap.put(cnt, node.pre);
//         } else if (mruMap.get(cnt) != node && lruMap.get(cnt) == node) {
//             lruMap.put(cnt, node.next);
//         }
//         deleteNode(node);

//         return val;
//     }

//     public void put(int key, int value) {
//         if (capacity <= 0) return;
//         if (keyMap.containsKey(key)) {
//             Node node = keyMap.get(key);
//             keyMap.remove(key);
//             int cnt = node.cnt;
//             cnt++;
//             if (mruMap.containsKey(cnt)) {
//                 Node p = mruMap.get(cnt);
//                 insertNode(p, key, value, cnt);
//                 mruMap.put(cnt, p.next);
//                 keyMap.put(key, p.next);
//             } else {
//                 Node p = mruMap.get(node.cnt);
//                 insertNode(p, key, value, cnt);
//                 mruMap.put(cnt, p.next);
//                 lruMap.put(cnt, p.next);
//                 keyMap.put(key, p.next);
//             }

//             cnt--;
//             if (mruMap.get(cnt) == node && lruMap.get(cnt) == node) { // node is mru and lru
//                 mruMap.remove(cnt);
//                 lruMap.remove(cnt);
//             } else if (mruMap.get(cnt) == node && lruMap.get(cnt) != node) {
//                 mruMap.put(cnt, node.pre);
//             } else if (mruMap.get(cnt) != node && lruMap.get(cnt) == node) {
//                 lruMap.put(cnt, node.next);
//             }
//             deleteNode(node);
//         } else {
//             if (size == capacity) {
//                 keyMap.remove(head.next.key, head.next);
//                 if (mruMap.get(head.next.cnt) == head.next) {
//                     mruMap.remove(head.next.cnt);
//                     lruMap.remove(head.next.cnt);
//                 } else {
//                     lruMap.put(head.next.cnt, head.next.next);
//                 }

//                 keyMap.remove(head.next.key);
//                 deleteNode(head.next);
//             }

//             if (mruMap.containsKey(1)) {
//                 Node p = mruMap.get(1);
//                 insertNode(p, key, value, 1);
//                 mruMap.put(1, p.next);
//                 keyMap.put(key, p.next);
//             } else {
//                 insertNode(head, key, value, 1);
//                 mruMap.put(1, head.next);
//                 lruMap.put(1, head.next);
//                 keyMap.put(key, head.next);
//             }
//         }
//     }

//     private void deleteNode(Node node) {
//         node.pre.next = node.next;
//         node.next.pre = node.pre;
//         node.next = null;
//         node.pre = null;
//         size--;
//     }

//     private void insertNode(Node node, int key, int val, int cnt) {
//         Node p = new Node(key, val);
//         p.cnt = cnt;
//         p.next = node.next;
//         p.pre = node;
//         node.next = p;
//         p.next.pre = p;
//         size++;
//     }

//     public static void main(String[] args) {
//         LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

//         cache.put(1, 1);
//         cache.put(2, 2);
//         System.out.println(cache.get(1));       // 返回 1
//         cache.put(3, 3);    // 去除 key 2
//         System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
//         System.out.println(cache.get(3));       // 返回 3
//         cache.put(4, 4);    // 去除 key 1
//         System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
//         System.out.println(cache.get(3));       // 返回 3
//         System.out.println(cache.get(4));       // 返回 4
//     }
// }

class LFUCache {

    private HashMap<Integer, Integer> valMap = new HashMap<>();    // key -> val
    private HashMap<Integer, Integer> countMap = new HashMap<>();  // key -> cnt
    private HashMap<Integer, LinkedHashSet<Integer>> setMap = new HashMap<>();  // cnt -> set
    private int MIN = -1; 
    private int CAPACITY = 0;

    public LFUCache(int capacity) {
        this.CAPACITY = capacity;
    }
    
    public int get(int key) {
        if (!valMap.containsKey(key)) return -1;
        int val = valMap.get(key);
        int cnt = countMap.get(key);
        countMap.put(key, cnt + 1);
        setMap.get(cnt).remove(key);
        if (cnt == MIN && setMap.get(cnt).isEmpty()) {
            MIN++;
        }
        if (!setMap.containsKey(cnt + 1)) {
            setMap.put(cnt + 1, new LinkedHashSet<>());
        }
        setMap.get(cnt + 1).add(key);
        return val;
    }
    
    public void put(int key, int value) {
        if (CAPACITY <= 0) return;
        if (valMap.containsKey(key)) {
            valMap.put(key, value);
            get(key);
            return;
        }

        if (valMap.size() == CAPACITY) {
            int removeKey = setMap.get(MIN).iterator().next();
            setMap.get(MIN).remove(removeKey);
            valMap.remove(removeKey);
            countMap.remove(removeKey);
            if (setMap.get(MIN).isEmpty()) setMap.remove(MIN);
        }
        valMap.put(key, value);
        countMap.put(key, 1);
        MIN = 1;
        if (!setMap.containsKey(1)) {
            setMap.put(1, new LinkedHashSet<>());
        }
        setMap.get(1).add(key);
    }
}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */