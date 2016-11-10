/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if (root == null)
            return;
            
        TreeLinkNode cursor = null;
        LinkedList<TreeLinkNode> list = new LinkedList<>();
        list.add(root);
        TreeLinkNode endLevel = root;
        while (!list.isEmpty()) {
            cursor = list.removeFirst();
            if (cursor == endLevel) {
                endLevel = null;
                cursor.next = null;
            } else {
                cursor.next = list.getFirst();
            }
            if (cursor.left != null)
                list.add(cursor.left);
            if (cursor.right != null)
                list.add(cursor.right);
            if (endLevel == null && !list.isEmpty())
                endLevel = list.getLast();
        }
    }
}