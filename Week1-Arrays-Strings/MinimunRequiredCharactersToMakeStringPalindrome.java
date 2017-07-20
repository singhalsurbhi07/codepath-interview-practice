/**You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

 Example:
 Input: ABC
 Output: 2
 Input: AACECAAAA
 Output: 2*/

public class MinimumRequiredCharactersToMakeStringPalindrome {

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        int i=0;
        int j=s.length()-1;

        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i+=1;
            j-=1;
        }

        return true;
    }

    public int solve(String A) {
        int lastIndexOfPalindrome = 0;
        for (int i=1; i<A.length(); i++) {
            if (isPalindrome(A.substring(0, i+1))) {
                lastIndexOfPalindrome = i;
            }
        }
        return (A.length()-1) - lastIndexOfPalindrome;
    }
}
