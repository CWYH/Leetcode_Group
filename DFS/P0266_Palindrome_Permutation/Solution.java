/**
 * 266. Palindrome Permutation -- Easy
 * 
 * Microsoft, Facebook
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 * 
 * Input: "code"
 * Output: false
 * Example 2:
 * 
 * Input: "aab"
 * Output: true
 * Example 3:
 * 
 * Input: "carerac"
 * Output: true
 * 
 */

import java.util.HashMap; 

class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        int oddNum = 0;
        for (char c : h.keySet()) {
            if (h.get(c) % 2 != 0) {
                oddNum++;
            }
            if (oddNum > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abbacccd";
        System.out.println(s.canPermutePalindrome(str));
    }
}