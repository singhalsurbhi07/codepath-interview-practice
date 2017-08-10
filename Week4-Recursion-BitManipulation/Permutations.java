/***
 *
 Given a collection of numbers, return all possible permutations.

 Example:

 [1,2,3] will have the following permutations:

 [1,2,3]
 [1,3,2]
 [2,1,3]
 [2,3,1]
 [3,1,2]
 [3,2,1]
 NOTE
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 Example : next_permutations in C++ / itertools.permutations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Permutations {
    private void permutationHelper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result,
                                   ArrayList<Integer> currentList) {

        if (a.size() == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < a.size(); i++) {

            int current = a.remove(i);
            //System.out.println(current);
            currentList.add(current);
            permutationHelper(a, result, currentList);
            //System.out.println("-->>>"+ i);
            a.add(i, new Integer(current));
            //System.out.println("XXCXXXX" + currentList.size());
            currentList.remove(currentList.remove(currentList.size() - 1));
        }
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        if (a == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        permutationHelper(a, result, new ArrayList<>());
        return result;

    }
}