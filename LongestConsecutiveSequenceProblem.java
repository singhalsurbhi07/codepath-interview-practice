import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Example:
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequenceProblem {

    public int longestConsecutive(final List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int n : a) {
            if (!map.containsKey(n)) {
                int smaller_elements_count = map.containsKey(n-1) ? map.get(n-1) : 0;
                int larger_elements_count = map.containsKey(n+1) ? map.get(n+1) : 0;

                int total = smaller_elements_count + larger_elements_count + 1;
                map.put(n, total);
                max = Math.max(max, total);
                map.put(n-smaller_elements_count, total);
                map.put(n+larger_elements_count, total);
            }
        }

        return max;
    }

}
