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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) 
            helper(root, "", answer);
        return answer;
    }
    
    public void helper (TreeNode root, String path, List<String> list) {
        if (root == null)
            return;
            
        if(root.left == null && root.right == null) {
            list.add(path + root.val);
            return;
        }
        
        String p1 = path + root.val + "->";
        helper(root.left, p1, list);
        helper(root.right, p1, list);
        return;
    }
}
