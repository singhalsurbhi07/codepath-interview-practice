/**Given a singly linked list

 L: L0 → L1 → … → Ln-1 → Ln,
 reorder it to:

 L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 You must do this in-place without altering the nodes’ values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

public class ReorderList {
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public ListNode reorderList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode slow = a;
        ListNode fast = a;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println(slow.val);
            // System.out.println(fast.val);
        }



        ListNode front_head = a;
        ListNode back_head = reverseList(slow.next);
        slow.next = null;
        ListNode front_next;
        ListNode back_next;
        while(front_head != null && back_head != null) {
            front_next = front_head.next;
            back_next = back_head.next;
            front_head.next = back_head;
            back_head.next = front_next;
            front_head = front_next;
            back_head = back_next;
        }

        return a;

    }
}