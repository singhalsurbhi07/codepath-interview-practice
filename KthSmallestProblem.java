import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 Find the kth smallest element in an unsorted array of non-negative integers.

 Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
 In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based )
 NOTE
 You are not allowed to modify the array ( The array is read only ).
 Try to do it using constant extra space.

 Example:

 A : [2 1 4 3 2]
 k : 3

 answer : 2
 */
public class KthSmallestProblem {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> a, int k) {
        if (k > a.size()) {
            return -1;
        }
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i < a.size(); i++) {
            minheap.add(a.get(i));
        }

        int minValue = 0;
        for (int i = 0; i < k; i++) {
            minValue = minheap.poll();
        }
        return minValue;
    }

}
