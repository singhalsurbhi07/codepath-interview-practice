/**Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

 Sample Input:

 [3 4 1 4 1]
 Sample Output:

 1
 If there are multiple possible answers ( like in the sample case above ), output any one.

 If there is no duplicate, output -1*/
public class FindDuplicateInArray {

    private int num_buckets;
    private int last_bucket_size;
    private int bucket_size;
    private int getPartsIndexForNumber(int num) {
        // System.out.println(num + " " + part_size);
        return (num-1)/bucket_size;
    }

    private boolean ifExcessInBucket(int index, int count) {
        if (index == num_buckets-1) { // last bucket
            return count > last_bucket_size;
        }
        return count > bucket_size;

    }

    private int findNumberinPart(int index, List<Integer> a) {
        int start = (index*bucket_size) + 1;
        int end = start + bucket_size -1;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i< a.size(); i++) {
            int num = a.get(i);
            if (num >=start && num <= end) {
                if (map.containsKey(num)) {
                    return num;
                } else {
                    map.put(num, true);
                }
            }
        }

        return -1;

    }
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int a_size = a.size()-1;
        // System.out.println(a_size);
        num_buckets = (int)Math.ceil(Math.sqrt(a_size));
        // System.out.println("-->"+ parts_size);
        int [] buckets = new int [num_buckets];

        bucket_size = (int)Math.round(Math.sqrt(a_size));

        last_bucket_size = a_size - (bucket_size * (num_buckets-1));

        for (int i=0; i< a.size();i++) {
            int index = getPartsIndexForNumber(a.get(i));
            //System.out.println(index);
            buckets[index] += 1;
            // System.out.println("//"+parts[index]);
            if (ifExcessInBucket(index, buckets[index])) {
                return findNumberinPart(index, a);
            }
        }

        return -1;


    }
}
