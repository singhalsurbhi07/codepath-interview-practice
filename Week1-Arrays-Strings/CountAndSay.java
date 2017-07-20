/*The count-and-say sequence is the sequence of integers beginning as follows:

        1, 11, 21, 1211, 111221, ...
        1 is read off as one 1 or 11.
        11 is read off as two 1s or 21.

        21 is read off as one 2, then one 1 or 1211.

        Given an integer n, generate the nth sequence.

        Note: The sequence of integers will be represented as a string.

        Example:

        if n = 2,
        the sequence is 11.*/

public class CountAndSay {

    private String createSeq(char character, int count) {
        return (new Integer(count).toString()+character);
    }
    private String getNext(String current) {
        char current_char = current.charAt(0);
        int current_char_count = 1;

        StringBuffer buffer = new StringBuffer();
        for (int i=1; i< current.length(); i++) {
            if (current.charAt(i) != current_char) {
                buffer.append(createSeq(current_char, current_char_count));
                current_char = current.charAt(i);
                current_char_count = 1;
            } else {
                current_char_count += 1;
            }
        }

        buffer.append(createSeq(current_char, current_char_count));
        return buffer.toString();
    }
    public String countAndSay(int a) {
        if (a ==0) {
            return "";
        }

        String start = "1";
        int count = 1;

        while(count<a) {
            start = getNext(start);
            count += 1;

        }

        return start;
    }
}
