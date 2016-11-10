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
    
    List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        int pathSum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        util(root, sum, pathSum, list);
        return pathsList;
    }

    private void util(TreeNode root, int sum, int pathSum, ArrayList<Integer> list) {

        if (root == null) 
            return;
            
        list.add(root.val);
        pathSum += root.val;
        if (root.left == null && root.right == null) {
            if (pathSum == sum)
                pathsList.add(list);
            return;
        }
        
        ArrayList<Integer> copiedList = new ArrayList<>();
        copiedList.addAll(list);
        util(root.left, sum, pathSum, list);
        util(root.right, sum, pathSum, copiedList);
    }
}