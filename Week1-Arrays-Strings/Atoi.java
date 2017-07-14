/*There are certain questions where the interviewer would intentionally frame the question vague.
        The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

        Implement atoi to convert a string to an integer.

        Example :

        Input : "9 2704"
        Output : 9
        Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

        Questions: Q1. Does string contain whitespace characters before the number?
        A. Yes Q2. Can the string have garbage characters after the number?
        A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
        A. Return 0. Q4. What if the integer overflows?
        A. Return INT_MAX if the number is positive, INT_MIN otherwise.*/


public class Atoi {
    public int atoi(final String a) {
        if (a.length() == 0) {
            return 0;
        }

        char[] char_a = a.toCharArray();
        StringBuffer buffer = new StringBuffer();
        boolean hasSign = false;

        for (int i=0; i< char_a.length; i++) {
            char current = char_a[i];
            if (i==0 && (current=='-' || current=='+')) {
                hasSign = true;
            }else if (Character.isDigit(current)) {
                buffer.append(current);
            } else {
                break;
            }
        }

        char[] finalInput = buffer.toString().toCharArray();

        int pow = 0;
        long num = 0;
        for (int i= finalInput.length-1; i>=0; i--) {
            char current = finalInput[i];
            num += (Math.pow(10, pow) * Integer.parseInt(String.valueOf(current)));
            pow += 1;
        }

        boolean isNegative = hasSign?char_a[0]=='+'?false:true:false;

        long ans = isNegative?Math.max(-1*num, Integer.MIN_VALUE):Math.min(num, Integer.MAX_VALUE) ;
        return (int)ans;
    }
}
