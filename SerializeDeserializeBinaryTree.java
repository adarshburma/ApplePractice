/*
  Leetcode: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int i = 0;

    public void serializeHelper (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        
        sb.append(root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public TreeNode deserializeHelper(String[] vals) {
        if (vals[i].equals("N")) {
            i++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
        i++;
        node.left = deserializeHelper(vals);
        node.right = deserializeHelper(vals);
        
        return node;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
