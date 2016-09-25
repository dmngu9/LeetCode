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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
            
        if ((isInSubTree(root.left, p) && isInSubTree(root.right, q))
           || (isInSubTree(root.left, q) && isInSubTree(root.right, p))
           || (root == p && (isInSubTree(root.left, q) || isInSubTree(root.right, q)))
           || (root == q && (isInSubTree(root.left, p) || isInSubTree(root.right, p))))
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) 
            return left;
        else if (right != null)
            return right;
        return null;
    }
    
    private boolean isInSubTree(TreeNode root, TreeNode p) {
        if (root == null) 
            return false;
        if (root == p)
            return true;
        return isInSubTree(root.left, p) || isInSubTree(root.right, p);
    }
}