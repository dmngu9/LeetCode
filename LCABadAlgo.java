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
            return null;
        if (root == p) {
            if (inSubTree(root.left, q) || inSubTree(root.right, q))
                return root;
        } else if (root == q) {
            if (inSubTree(root.left, p) || inSubTree(root.right, p))
                return root;
        } else {
            if ((inSubTree(root.left, q) && inSubTree(root.right, p))
                || (inSubTree(root.left, p) && inSubTree(root.right, q)))
                return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode res = null;
        if (left != null)
            res = left;
        else if (right != null)
            res = right;
        return res;
    }
    
    public boolean inSubTree(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        if (root == p)
            return true;
        boolean left = inSubTree(root.left, p);
        boolean right = inSubTree(root.right, p);
        return (left || right);
    }
}
