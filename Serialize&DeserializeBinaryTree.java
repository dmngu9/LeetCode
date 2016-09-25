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

    private int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String result = "";
        if (root == null) {
            return "null,";
        }
        
        result += root.val;
        result += ",";
        result += serialize(root.left);
        result += serialize(root.right);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] value = data.split(",");
        return helper(value);
    }
    
    private TreeNode helper(String[] value) {
        if (value.length == 0 || value[index].equals("null") || index == value.length) {
           index++;
           return null; 
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(value[index]));
        index++;
        root.left = helper(value);
        root.right = helper(value);
        return root;
    }
}