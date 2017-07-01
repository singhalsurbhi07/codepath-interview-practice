import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ssinghal on 7/1/17.
 */
public class AllUniquePermutationsProblem {

    private void permuteHelper(ArrayList<Integer> temp, ArrayList<Integer> input,
                               ArrayList<ArrayList<Integer>> result, int len, boolean hasDuplicate) {

        if (temp.size() == len) {
            if (hasDuplicate) {
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            } else {
                result.add(temp);
            }

            return;
        }

        for (int i=0; i<input.size(); i++) {
            int element = input.get(i);
            ArrayList<Integer> tempCopy = new ArrayList<>(temp);
            tempCopy.add(element);
            ArrayList<Integer> nextInput = new ArrayList<>(input);
            nextInput.remove(new Integer(element));
            permuteHelper(tempCopy, nextInput, result, len, hasDuplicate);

        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int len = a.size();

        if (a == null || len == 0) {
            return result;
        }

        if (len == 1) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(a.get(0));
            result.add(l);
            return result;
        }

        Collections.sort(a);

        boolean hasDuplicate = false;

        for (int i = 1; i < len; i++) {
            if (a.get(i) == a.get(i - 1)) {
                hasDuplicate = true;
                break;
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        permuteHelper(temp, a, result, len, hasDuplicate);
        return result;
    }
}
