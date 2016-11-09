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
    
    private int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        validPath(root, sum, list);
        return count;
    }
    
    private void validPath(TreeNode root, int sum, ArrayList<Integer> list) {
        
        if (root == null)
            return;
        if (root.val == sum)
            count++;
            
        list.add(root.val);
        for (int i = 0; i < list.size() - 1; i++) {
            list.set(i, list.get(i) + root.val);
            if (list.get(i) == sum)
                count++;
        }
        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.addAll(list);
        validPath(root.left, sum, list);
        validPath(root.right, sum, anotherList);
    }
}