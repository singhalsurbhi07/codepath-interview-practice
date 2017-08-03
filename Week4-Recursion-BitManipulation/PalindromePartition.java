/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example,
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
 */
public class PalindromePartition {

    private boolean isDuplicate(ArrayList<ArrayList<Integer>> result,
                                ArrayList<Integer> currentList) {

        Collections.sort(currentList);
        if (result.contains(currentList)) {
            System.out.println("currentList is in result");
        }
        return result.contains(currentList);
    }

    private void getAllCombinations(ArrayList<Integer> a, int b,
                                    ArrayList<ArrayList<Integer>> result, int sum, ArrayList<Integer> currentList,
                                    int index) {

        for (int i = index; i < a.size(); i++) {
            int currentSum = sum + a.get(i);
            currentList.add(a.get(i));
            // System.out.println("sum =" + sum + "  " + "currentSum" + currentSum);
            if (currentSum == b) {
                // System.out.println("currentSum = b");
                result.add(new ArrayList<>(currentList));

            } else if (currentSum < b) {

                getAllCombinations(a, b, result, currentSum, currentList, i);
            }

            currentList.remove(currentList.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (a == null || a.size() == 0) {
            return result;
        }

        ArrayList<Integer> deDupStringList = new ArrayList<>(new HashSet<>(a));
        Collections.sort(deDupStringList);
        getAllCombinations(deDupStringList, b, result, 0, new ArrayList<Integer>(), 0);
        return result;

    }
}