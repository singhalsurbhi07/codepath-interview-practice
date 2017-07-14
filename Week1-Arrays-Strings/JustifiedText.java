/*Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
        You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

        Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
        Extra spaces between words should be distributed as evenly as possible.
        If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
        For the last line of text, it should be left justified and no extra space is inserted between words.

        Your program should return a list of strings, where each string represents a single line.

        Example:

        words: ["This", "is", "an", "example", "of", "text", "justification."]

        L: 16.

        Return the formatted lines as:

        [
        "This    is    an",
        "example  of text",
        "justification.  "
        ]
        Note: Each word is guaranteed not to exceed L in length.
        */

public class JustifiedText {
    private void addStringsToresult(ArrayList<String> a, int start, int end, int currentlength, ArrayList<String> result, int b) {
        System.out.println(start + " " + end + " " + currentlength);
        int gaps = end - start;
        if (gaps > 0) {
            int[] gapsArray = new int[gaps];
            int min_gaps_length = (b - currentlength) / gaps;
            int remaining = (b - currentlength) % gaps;
            for (int i = 0; i < gapsArray.length; i++) {
                gapsArray[i] = min_gaps_length;
            }
            int j = 0;
            while (remaining > 0) {
                gapsArray[j] += 1;
                remaining -= 1;
                j += 1;
            }

            StringBuffer buffer = new StringBuffer();
            for (int i = start; i < end; i++) {
                buffer.append(a.get(i));
                // System.out.println(gapsArray[i]);
                while (gapsArray[i - start] > 0) {
                    buffer.append(" ");
                    gapsArray[i - start] -= 1;
                }
            }
            buffer.append(a.get(end));
            result.add(buffer.toString());
        } else {
            addLastStringsToresult(a, start, end, currentlength, result, b);
        }
    }

    private void addLastStringsToresult(ArrayList<String> a, int start, int end, int currentlength, ArrayList<String> result, int b) {
        int totalStringLength = 0;

        int gaps_length = (b - currentlength);

        StringBuffer buffer = new StringBuffer();
        int doneLength = 0;
        for (int i=start; i<=end; i++) {
            buffer.append(a.get(i));
            buffer.append(" ");
            doneLength = a.get(i).length() + 1;
        }

        while(doneLength <= b) {
            buffer.append(" ");
            doneLength += 1;
        }


        result.add(buffer.toString());

    }

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<String>();

        if (a.size() == 0 || b == 0) {
            return result;
        }

        int currentlength = 0;
        int gaps = 0;
        int start = 0;
        for (int i = 0; i < a.size(); i++) {

            if (currentlength + gaps + a.get(i).length() > b) {
                addStringsToresult(a, start, i-1, currentlength, result, b);
                start = i;
                gaps=1;
                currentlength = a.get(i).length();
            } else {
                currentlength += a.get(i).length();
                gaps+=1;
            }
        }
        addLastStringsToresult(a, start, a.size()-1, currentlength, result, b);

        return result;
    }
}