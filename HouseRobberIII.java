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
    public int rob(TreeNode root) {
        
        int[] result = robHelper(root);
        int val = Math.max(result[0], result[1]);
        return val;
    }
    
    private int[] robHelper(TreeNode root) {
        
        if (root == null) {
            int[] result = new int[2];
            return result;
        }
        
        int[] leftBranch = robHelper(root.left);
        int[] rightBranch = robHelper(root.right);
        int[] result = new int[2];
        
        //result[0] is for root robbed, result[1] is for root not robbed
        result[0] = root.val + leftBranch[1] + rightBranch[1];
        result[1] = Math.max(leftBranch[0], leftBranch[1]) + Math.max(rightBranch[0], rightBranch[1]);
        
        return result;
    }
}