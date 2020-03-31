import java.util.HashMap;

/**
 * 246. Strobogrammatic Number -- Easy
 * 

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true

Example 2:

Input:  "88"
Output: true

Example 3:

Input:  "962"
Output: false
 */

class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> h = new HashMap<>();
        h.put('0', '0');
        h.put('1', '1');
        h.put('8', '8');
        h.put('6', '9');
        h.put('9', '6');

        for (int i = 0; i <= num.length() / 2; i++) {
            char c = num.charAt(i);
            if (!h.containsKey(c)) return false;
            if (h.get(c) != num.charAt(num.length() - 1 - i)) return false;
        }
        return true;
    }
}