public class MergeKSortedList {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a == null || a.size() == 0) {
            return null;
        }
        int len = a.size();
        if (len == 1) {
            return a.get(0);
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                } else if (l1.val == l2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < len ; i++) {
            if (a.get(i) != null) {
                q.add(a.get(i));
            }
        }

        ListNode head = null;
        ListNode end = null;

        while (!q.isEmpty()) {
            ListNode current = q.poll();
            if (head == null) {
                head = current;
                end = current;
            } else {
                end.next = current;
                end = current;
            }

            if (current.next != null) {
                q.add(current.next);
            }

        }

        return head;
    }
}