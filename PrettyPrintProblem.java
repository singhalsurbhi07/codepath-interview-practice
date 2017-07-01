import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix.
 Let us show you some examples to clarify what we mean.

 Example 1:

 Input: A = 4.
 Output:

 4 4 4 4 4 4 4
 4 3 3 3 3 3 4
 4 3 2 2 2 3 4
 4 3 2 1 2 3 4
 4 3 2 2 2 3 4
 4 3 3 3 3 3 4
 4 4 4 4 4 4 4
 Example 2:

 Input: A = 3.
 Output:

 3 3 3 3 3
 3 2 2 2 3
 3 2 1 2 3
 3 2 2 2 3
 3 3 3 3 3
 The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

 You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrintProblem {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        int n = 2 * a - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start1 = a;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int primary = Math.abs(start1);
            int count = primary * 2 - 1;
            int check = 1;
            int start = a;
            for (int j = 0; j < n; j++) {
                if (start == primary) {
                    while (count >= 1) {
                        temp.add(Math.abs(start));
                        count -= 1;
                        j++;
                    }
                    j -= 1;
                    check *= -1;
                } else {
                    temp.add(Math.abs(start));
                }
                start = start - check;
                if (start == 0) {
                    start = start - 2;
                }

            }
            result.add(temp);

            start1 = start1 - 1;
            if (start1 == 0) {
                start1 -= 2;
            }
        }
        return result;
    }

}
