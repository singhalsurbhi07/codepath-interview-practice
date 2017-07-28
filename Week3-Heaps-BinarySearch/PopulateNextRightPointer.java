public class PopulateNextRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);


        int count;
        while (!q.isEmpty()) {
            count = q.size();
            while(count > 0) {
                TreeLinkNode current = q.poll();
                if (count > 1) {
                    current.next = q.peek();
                } else {

                    current.next = null;
                }
                count -= 1;

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }

            }

        }

    }
}
