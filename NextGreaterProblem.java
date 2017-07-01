import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array.
        More formally,

        G[i] for an element A[i] = an element A[j] such that
        j is minimum possible AND
        j > i AND
        A[j] > A[i]
        Elements for which no greater element exist, consider next greater element as -1.

        Example:

        Input : A : [4, 5, 2, 10]
        Output : [5, 10, 10, -1]

        Example 2:

        Input : A : [3, 2, 1]
        Output : [-1, -1, -1]*/


public class NextGreaterProblem {

    class IndexAndValue {
        public int index;
        public int value;

        public IndexAndValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();

        if (a == null || a.size()==0) {
            return result;
        }

        for (int j=0; j<a.size(); j++) {
            result.add(-1);
        }

        if (a.size()==1) {
            return result;
        }

        Deque<IndexAndValue> s = new LinkedList<>();
        s.push(new IndexAndValue(0, a.get(0)));

        for (int i=1; i<a.size(); i++) {
            int current = a.get(i);
            while (s.size()>0 && current > s.peek().value) {
                IndexAndValue popElement = s.pop();
                result.set(popElement.index, current);
            }
            s.push(new IndexAndValue(i, current));
        }

        return result;
    }

}
