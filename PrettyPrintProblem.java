import java.util.ArrayList;

/**
 * Created by ssinghal on 7/1/17.
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
