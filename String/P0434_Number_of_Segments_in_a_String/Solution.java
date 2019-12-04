/**
 * 434. Number of Segments in a String -- Easy
 */

class Solution {
    public int countSegments(String s) {
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    res++;
                    flag = false;
                }
            } else if (s.charAt(i) != ' ') {
                flag = true;
                if (i == s.length() - 1) res++;
            }
        }
        return res;
    }
}