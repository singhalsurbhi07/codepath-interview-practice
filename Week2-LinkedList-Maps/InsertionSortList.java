/**Sort a linked list using insertion sort.

 We have explained Insertion Sort at Slide 7 of Arrays

 Insertion Sort Wiki has some details on Insertion Sort as well.

 Example :

 Input : 1 -> 3 -> 2

 Return 1 -> 2 -> 3*/

public class InsertionSortList {
    private ListNode moveMode(ListNode prev, ListNode node, ListNode head, boolean moveInFront) {
        // System.out.println(prev.val + "   "+ node.val );
        ListNode newNode = new ListNode(node.val);

        if (moveInFront) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = prev.next;
            prev.next = newNode;
        }

        ListNode current = head;

        while(current.next != node) {
            // System.out.println(node.val + "    "+ current.val);
            current =  current.next;
        }
        current.next = node.next;

        return head;
    }

    private void moveInFront(ListNode node, ListNode head) {
        ListNode newNode = new ListNode(node.val);
        newNode.next = head;
        head = newNode;

        ListNode current = node;
        while(current.next != null) {
            current.val = current.next.val;
            current = current.next;
        }
        current = null;

    }

    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode current = a.next;


        while (current != null) {
            ListNode prev = a;
            ListNode next = current.next;
            //  System.out.println("-----------------");
            while(prev != current) {
                // System.out.println("prev===" + prev.val);
                if (a.val > current.val) {
                    a = moveMode(prev, current, a, true);
                    break;
                }else if (prev.val < current.val && prev.next.val > current.val) {
                    a = moveMode(prev, current, a, false);
                    break;
                } else {
                    prev = prev.next;
                }
                // System.out.println("prev===" + prev.val);

            }
            current = next;

        }
        return a;
    }
}
