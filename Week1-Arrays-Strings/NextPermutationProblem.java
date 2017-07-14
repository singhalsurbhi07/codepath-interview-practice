/**Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

        If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

        The replacement must be in-place, do not allocate extra memory.

        Examples:

        1,2,3 → 1,3,2

        3,2,1 → 1,2,3

        1,1,5 → 1,5,1

        20, 50, 113 → 20, 113, 50*/

public class NextPermutationProblem {
    private int findNext(ArrayList<Integer> input, int target, int start) {
        ArrayList<Integer> temp = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = start + 1; i < input.size(); i++) {
            if (input.get(i) > target && input.get(i) < min) {
                min = input.get(i);
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void nextPermutation(ArrayList<Integer> a) {
        boolean foundNext = false;
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) < a.get(i + 1)) {
                int temp = a.get(i);
                int nextIndex = findNext(a, temp, i);
                a.set(i, a.get(nextIndex));
                a.set(nextIndex, temp);
                Collections.sort(a.subList(i + 1, a.size()));
                foundNext = true;
                break;
            }
        }

        if (!foundNext) {
            Collections.sort(a);
        }
    }
}