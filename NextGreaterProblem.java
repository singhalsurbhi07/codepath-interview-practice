import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ssinghal on 7/1/17.
 */
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
