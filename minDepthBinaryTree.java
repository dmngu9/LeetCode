/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
        
        int result = 0;
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (leftHeight == 0 && rightHeight > 0)
            result = rightHeight;
        else if (leftHeight > 0 && rightHeight == 0)
            result = leftHeight;
        else if (leftHeight == 0 && rightHeight == 0)
            result = 0;
        else 
            result = Math.min(leftHeight, rightHeight);
        return result + 1;
    }
}