public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        if (a == null) {
            return null;
        }

        Map<ListNode, Boolean> nodeMap = new HashMap<>();
        ListNode current = a;
        // boolean loopFound = false;
        while (current != null) {
            nodeMap.put(current, true);
            if (nodeMap.containsKey(current.next)) {
                // loopFound = true;
                return current.next;

            }
            current = current.next;
        }

        return null;
    }
}