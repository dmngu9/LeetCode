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
    
    private TreeNode cursor = null;
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
            
        TreeNode leftBranch = root.left;
        TreeNode rightBranch = root.right;
        root.left = null;
        root.right = null;
        flatten(leftBranch);
        flatten(rightBranch);
        
        if (leftBranch != null)
            root.right = leftBranch;
        while (root.right != null)
            root = root.right;
        root.right = rightBranch;
    }
}