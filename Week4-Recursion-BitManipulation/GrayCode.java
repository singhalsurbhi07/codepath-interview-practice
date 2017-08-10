/**Gray CodeBookmark Suggest Edit
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.*/
public class GrayCode {

    private void grayCodeHelper(ArrayList<Integer> result, int max, int factor) {
        int resultSize = result.size() - 1;
        for (int i = resultSize; i >= 0; i--) {
            int current = result.get(i);
            if ((current + factor) > max) {
                return;
            }
            //System.out.println(current + factor);
            result.add(current + factor);

        }

        grayCodeHelper(result, max, factor * 2);
    }

    public ArrayList<Integer> grayCode(int a) {

        if (a == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        double max = Math.pow(2.0, (double)a);

        grayCodeHelper(result, (int)max, 1);
        return result;
    }
}