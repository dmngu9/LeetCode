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
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0 , sum);
    }
    
    public boolean helper(TreeNode root, int sum, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == target)
                return true;
            return false;
        }
        
        sum += root.val;
        boolean left = helper(root.left, sum, target);
        boolean right = helper(root.right, sum, target);
        return left || right;
    }
}
