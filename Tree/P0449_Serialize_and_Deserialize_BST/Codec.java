import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 449. Serialize and Deserialize BST -- Medium
 * 
 * MS
 */


public class Codec {

    /**
     * Definition for a binary tree node.
     */ 
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(String.valueOf(root.val));
            sb.append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return deserializeHelper(data_list);
    }

    private TreeNode deserializeHelper(List<String> data_list) {
        if (data_list.get(0).equals("#")) {
            data_list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data_list.get(0)));
        data_list.remove(0);
        root.left = deserializeHelper(data_list);
        root.right = deserializeHelper(data_list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));