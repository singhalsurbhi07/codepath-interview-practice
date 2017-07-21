/**Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

 Example :

 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC"

 Note:
 If there is no such window in S that covers all characters in T, return the empty string ''.
 If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).*/
 
public class Solution {
    class Pair {
        public char c;
        public int pos;

        public Pair(int pos, char c) {
            this.c = c;
            this.pos = pos;
        }
    }

    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return "";
        }

        int T_len = T.length();
        int S_len = S.length();

        if (T_len == 0 || S_len == 0 || S_len < T_len) {
            return "";
        }


        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        int minLength = S_len + 1;
        int start = -1;
        int end = -1;

        for(int i=0; i< T_len; i++) {
            char c = T.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                count += 1;
                map.put(c, 1);
            }
        }

        for (int i =0; i < S_len; i++) {
            char c = S.charAt(i);
            // System.out.println(c);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    count -= 1;
                }
                q.add(new Pair(i, c));
            }

            while(count == 0) {
                // System.out.println("count =0 ");
                Pair topmost = q.poll();
                // System.out.println(topmost.pos + "  "+ topmost.c);
                int currentLength = i - topmost.pos + 1;
                if (minLength > currentLength) {
                    minLength = currentLength;
                    start = topmost.pos;
                    end = i;
                }

                // update count
                map.put(topmost.c, map.get(topmost.c) + 1);
                if (map.get(topmost.c) ==  1) {
                    count += 1;
                }
            }
        }
        if (start == -1 && end == -1) {
            return "";
        }
        return S.substring(start, end + 1);
    }
}
