/**
 * Problem Setter: mihai.gheorghe
 Problem Tester: archit.rai
 Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

 Examples :
 Input
 0 2 5 7
 Output
 2 (0 XOR 2)
 Input
 0 4 7 9
 Output
 3 (4 XOR 7)

 Constraints:
 2 <= N <= 100 000
 0 <= A[i] <= 1 000 000 000
 */
public class MinXORValue {
    public int findMinXor(ArrayList<Integer> A) {
        if (A == null) {
            return 0;
        }

        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            min = Math.min(min, A.get(i) ^ A.get(i+1));
        }

        return min;
    }
}