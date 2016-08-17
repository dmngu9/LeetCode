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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        
        LinkedList<TreeNode> Q = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Q.add(root);
        list.add(root.val);
        int level = 0;
        map.put(root,level);
        
        while (!Q.isEmpty()) {
            TreeNode cursor = Q.removeFirst();
            if (cursor.left != null) {
                Q.add(cursor.left);
                map.put(cursor.left,map.get(cursor)+1);
            }
            if (cursor.right != null) {
                Q.add(cursor.right);
                map.put(cursor.right,map.get(cursor)+1);
            }
            
            if (!Q.isEmpty() && map.get(cursor) != map.get(Q.getFirst())) {
                list.add(Q.getLast().val);
            }
        }
        return list;
    }
}