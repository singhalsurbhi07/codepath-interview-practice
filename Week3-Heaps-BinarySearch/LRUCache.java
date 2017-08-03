/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.*/
public class LRUCache {

    class LinklistNode {
        int val;
        LinklistNode prev;
        LinklistNode next;

        public LinklistNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    Map<Integer, Integer> cache;
    Map<Integer, LinklistNode> nodeCache;
    LinklistNode start;
    LinklistNode end;
    int capacity;

    public Solution(int capacity) {
        this.cache = new HashMap<>();
        this.nodeCache = new HashMap<>();
        this.capacity = capacity;

    }

    private void removeAndInsertInFront(LinklistNode n) {
        if (start == n) {
            return;
        }

        if (end == n) {
            end = n.prev;
            end.next = null;
        } else {
            if (n.prev != null) {
                n.prev.next = n.next;
            }

            if (n.next != null) {
                n.next.prev = n.prev;

            }
        }

        n.prev = null;
        n.next = start;
        start.prev = n;
        start = n;

        if (start.next == end) {
            end.prev = start;
        }
    }

    public int get(int key) {
        // System.out.println("inside get");
        if (cache.containsKey(key)) {
            LinklistNode current = nodeCache.get(key);

            removeAndInsertInFront(current);
            return cache.get(key);
        }
        // System.out.println(start.val + "  " + end.val);
        return -1;
    }

    private void insertIntoBeginList(LinklistNode n) {
        if (start == null) {
            start = n;
            end = n;
            return;
        }

        n.next = start;
        start.prev = n;
        start = n;
    }

    private int deleteFromEndList() {

        int returnValue = end.val;
        if (start == end) {
            returnValue = start.val;
            start = null;
            end = null;
            return returnValue;
        }

        LinklistNode pre = end.prev;
        if (pre != null) {
            pre.next = null;
            end.prev = null;
            end = pre;
        }

        return returnValue;
    }

    public void set(int key, int value) {
        // System.out.println("inside set");

        if (cache.containsKey(key)) {
            cache.put(key, value);
            LinklistNode keyToremove = nodeCache.get(key);
            removeAndInsertInFront(keyToremove);
            // System.out.println(start.val + "  " + end.val);
            return;

        }
        if (cache.size() >= capacity) {
            int keyToRemove = deleteFromEndList();
            // System.out.println("key to remove" + keyToRemove);
            cache.remove(keyToRemove);
            nodeCache.remove(keyToRemove);

        }
        cache.put(key, value);
        LinklistNode newNode = new LinklistNode(key);
        insertIntoBeginList(newNode);
        nodeCache.put(key, newNode);
        // System.out.println(start.val + "  " + end.val);

    }
}

