/**
 * Given an array of integers, every element appears thrice except for one which occurs once.

 Find that element which does not appear thrice.

 Note: Your algorithm should have a linear runtime complexity.

 Could you implement it without using extra memory?

 Example :

 Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 Output : 4
 */
public class SingleNumber2 {

    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < a.size(); j++) {
                int current = a.get(j) >> i;
                if ((current & 1) == 1) {
                    sum += 1;
                }
                //a.set(j, current >> 1);
            }

            //System.out.println(sum);
            if (sum % 3 != 0) {
                int dig = 1<<i;
                result |= dig;
            }
            //System.out.println(result);
        }

        return result;
    }
}