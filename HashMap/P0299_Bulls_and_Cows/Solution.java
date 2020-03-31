import java.util.*;

/**
 * 299. Bulls and Cows -- Easy
 */

class Solution {
    public String getHint(String secret, String guess) {
        final int N = secret.length();
        StringBuffer sb = new StringBuffer();
        int[] digits = new int[10];
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < N; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                numA++;
            } else {
                digits[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                char c = guess.charAt(i);
                if (digits[c - '0'] > 0) {
                    numB++;
                    digits[c - '0']--;
                }
            }
        }
        sb.append(numA);
        sb.append("A");
        sb.append(numB);
        sb.append("B");
        return sb.toString();
    }
}