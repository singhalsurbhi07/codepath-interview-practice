/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0
*/

public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {

        if (a == null || a.size() == 0) {
            return -1;
        }

        int i = 0;
        int j = a.size() - 1;
        while (i < j) {
            //System.out.println(i + "  " + j);
            int mid = (i + j) / 2;
            int midValue = a.get(mid);
            //System.out.println(midValue);
            if (midValue == b) {
                return mid;
            }

            if (a.get(i) <= midValue) {
                if (b >= a.get(i) && b < midValue) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (b > midValue && b <= a.get(j)) {
                    i = mid + 1;
                } else {
                    j = mid -1;
                }
            }
        }

        return a.get(i) == b ? i : -1;
    }
}
