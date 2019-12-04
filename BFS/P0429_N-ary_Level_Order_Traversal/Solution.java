import java.util.*;

/**
 * 429. N-ary Tree Level Order Traversal -- Medium
 */

class Solution {
    /*
     * Definition for a Node.
     */
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        Queue<Node> tmpq = new LinkedList<>();
        q.offer(root);
        res.add(new ArrayList<Integer>(Arrays.asList(root.val)));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < cur.children.size(); i++) {
                tmpq.offer(cur.children.get(i));
            }
            if (q.isEmpty() && !tmpq.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                while (!tmpq.isEmpty()) {
                    Node node = tmpq.poll();
                    level.add(node.val);
                    q.offer(node);
                }
                res.add(level);
            }
        }
        return res;
    }
}