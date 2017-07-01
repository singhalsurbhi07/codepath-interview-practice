import java.util.ArrayList;

/**
 * Created by ssinghal on 7/1/17.
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
