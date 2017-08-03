/*Given two arrays A & B of size N each.
Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6),
9    (3+6),
9    (4+5),
8    (2+6)*/

public class NMaxPairCombination {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || B == null || A.size() == 0 || B.size() == 0) {
            return result;
        }

        int sizeA = A.size();
        int sizeB = B.size();

        if (sizeA != sizeB) {
            return result;
        }

        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        PriorityQueue<Integer> q = new PriorityQueue<>(sizeA);
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                int sum = A.get(i) + B.get(j);

                if (q.size() < sizeA) {
                    q.add(sum);
                } else if (sum > q.peek()) {
                    q.poll();
                    q.add(sum);
                } else {
                    break;
                }

            }
        }

        result = new ArrayList(q);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}