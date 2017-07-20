/**Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14
 Input : "XX"
 Output : 20
 */
public class Solution {
    private void createRomanToIntMap(Map<String, Integer> map) {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public int romanToInt(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        createRomanToIntMap(map);

        int len = a.length();
        int sum = 0;
        if (len == 1) {
            return map.get(a);
        }
        int i=1;
        int doneIndex=-1;
        while(i<len) {
            // System.out.println(i+ "  "+ sum);
            char current = a.charAt(i);
            char prev = a.charAt(i-1);

            int currentValue = map.get(String.valueOf(current));
            int prevValue =  map.get(String.valueOf(prev));
            // System.out.println( map.get(String.valueOf(prev)));
            if (currentValue > prevValue) {
                sum += map.get(String.valueOf(prev)+String.valueOf(current));
                doneIndex = i;
                i += 2;

            } else {
                sum += prevValue;
                doneIndex = i-1;
                i+=1;

            }

        }

        if (doneIndex < len-1) {
            sum += map.get(String.valueOf(a.charAt(doneIndex+1)));
        }

        return sum;

    }
}
