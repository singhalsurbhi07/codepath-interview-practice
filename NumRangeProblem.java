import java.util.ArrayList;

/**
 * Given an array of non negative integers A, and a range (B, C),
 find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

 Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 where 0 <= i <= j < size(A)

 Example :

 A : [10, 5, 1, 0, 2]
 (B, C) : (6, 8)
 ans = 3
 as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

 NOTE : The answer is guranteed to fit in a 32 bit signed integer.
 */
public class NumRangeProblem {
    private boolean isNumberInRange(int num, int b, int c) {
        if (num>=b && num <=c) {
            return true;
        }

        return false;
    }

    public int numRange(ArrayList<Integer> a, int b, int c) {

        int result = 0;

        if (a.size() == 0) {
            return result;
        }

        if (a.size() == 1) {
            return result = isNumberInRange(a.get(0), b, c) ? 1 : 0;
        }

        for (int i=0; i<a.size(); i++) {
            int currentSum = a.get(i);
            if (isNumberInRange(currentSum, b, c)) {
                result += 1;
            }
            for (int j=i-1; j>=0; j--) {
                currentSum += a.get(j);
                if (currentSum > c) {
                    break;
                }

                if (isNumberInRange(currentSum, b, c)) {
                    result += 1;
                }
            }
        }

        return result;

    }


}
