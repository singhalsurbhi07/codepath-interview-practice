import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ssinghal on 7/1/17.
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
