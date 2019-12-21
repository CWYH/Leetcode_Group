import java.util.*;

/**
 * 331. Verify Preorder Serialization of a Binary Tree -- Medium
 */

class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        String[] preArray = preorder.split(",");
        int diff = 1;  // diff = outdgree - indegree
        for (String node : preArray) {
            diff--;
            if (diff < 0) return false;
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(s.isValidSerialization(preorder));
    }
}