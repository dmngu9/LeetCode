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
    
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return sum;

        String num = "";
        util(root, num);
        return sum;
    }
    
    private void util(TreeNode root, String num) {
        
        if(root == null) {
            return;
        }
       
        num += Integer.toString(root.val);
        if (root.left == null && root.right == null){
            sum += Integer.parseInt(num);
            return;
        }
        String num2 = num;
        util(root.left, num);
        util(root.right, num2);
    }
}