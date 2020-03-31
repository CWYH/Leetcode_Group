import java.util.HashMap;

/**
 * 409. Longest Palindrome -- Easy
 */

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean hasOdd = false;
        int res = 0;
        for (Character c : h.keySet()) {
            if (h.get(c) % 2 == 0) {
                res += h.get(c);
            } else {
                hasOdd = true;
                res += (h.get(c) - 1);
            }
        }
        if (hasOdd) res++;
        return res;
    }
}