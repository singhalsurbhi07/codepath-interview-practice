public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        if (a == null || a.length() == 0 || b == null || b.size() == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String s : b) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
                count += 1;
            }
        }

        int word_length = b.get(0).length();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < a.length(); i++) {
            int j = i;
            int current_count = count;

            while(current_count > 0) {
                int start_index = j;
                int end_index = j + word_length;

                if (start_index > a.length() || end_index > a.length()) {
                    break;
                }

                String s = a.substring(start_index, end_index);
                if (map.containsKey(s) && map.get(s) > 0) {
                    map.put(s, map.get(s)-1);
                    if (map.get(s) == 0) {
                        current_count -= 1;
                    }
                    j += word_length;
                } else {
                    break;
                }
            }
            if (current_count == 0) {
                result.add(i);
            }

            for (int k = i; k < j; k += word_length) {
                String s = a.substring(k, k + word_length);
                map.put(s, map.get(s) + 1);
            }
        }

        return result;

    }
}