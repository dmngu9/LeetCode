/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;
    
        quickSort(head, tail);
        return head;
    }
    
    public ListNode[] partition(ListNode head, ListNode tail) {

        ListNode pIndex = head;
        ListNode pivot = tail;
        ListNode cursor = head;
        ListNode pivotPrev = null;
        while (cursor != tail) {
            if (cursor.val <= pivot.val) {
                int data = cursor.val;
                cursor.val = pIndex.val;
                pIndex.val = data;
                pivotPrev = pIndex;
                pIndex = pIndex.next;
            }
            cursor = cursor.next;
        }
        int data = pIndex.val;
        pIndex.val = pivot.val;
        pivot.val = data;
        
        ListNode pivotPost = null;
        if (pIndex != tail)
            pivotPost = pIndex.next;
            
        ListNode[] list = new ListNode[2];
        list[0] = pivotPrev;
        list[1] = pivotPost;
        
        System.out.println("prev "+list[0]);
        System.out.println("p "+list[1]);
        return list;
    }
    
    public void quickSort(ListNode head, ListNode tail) {
        if (head == null || head.next == null || head == tail || tail == null)
            return;
            
        System.out.println(head + " " + tail);
        
        ListNode[] list = partition(head, tail);

        quickSort(head, list[0]);
;
        quickSort(list[1], tail);
        
        return;
    }
}
