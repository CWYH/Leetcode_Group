import java.util.HashMap;

/**
 * 389. Find the Difference -- Easy
 */

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (h.getOrDefault(c, 0) == 0) {
                return c;
            } else {
                h.put(c, h.get(c) - 1);
            }
        }
        return ' ';
    }
}