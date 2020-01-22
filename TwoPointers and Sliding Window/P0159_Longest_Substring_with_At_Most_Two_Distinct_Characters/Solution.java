/**
 * 159. Longest Substring with At Most Two Distinct Characters -- Medium
 */

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int first = 0;
        int second = 0;
        int p = 0;
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res = Math.max(res, i - first + 1);
            } else {
                if (s.charAt(i) != s.charAt(first) && s.charAt(i) != s.charAt(second)) {
                    first = p;
                    second = i;
                    res = Math.max(res, i - first + 1);
                    p = i;
                } else {
                    res = Math.max(res, i - first + 1);
                    p = i;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abaccc";
        System.out.println(s.lengthOfLongestSubstringTwoDistinct(str));
    }
}