/**Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index*/

public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int size = a.size();

        long max = 0;
        long count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<size; i++) {
            // System.out.println("ef" + a.get(i));
            if (a.get(i) >= 0) {
                temp.add(a.get(i));
                count += a.get(i);
            } else {
                if ((count == max && temp.size() > result.size()) || (count > max)) {
                    result = new ArrayList<>(temp);
                    max = count;
                }

                temp = new ArrayList<>();
                count = 0;
            }

        }

        if (count > max) {
            result = new ArrayList<>(temp);

        }

        return result;

    }
}
