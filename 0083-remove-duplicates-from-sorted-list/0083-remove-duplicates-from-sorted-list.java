public class Solution {
    public ListNode deleteDuplicates(ListNode head){

        if (head == null) return null;

        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the next node since it's a duplicate
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}