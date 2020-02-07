/**
 * 294. Flip Game II -- Medium
 */

class Solution {
    public boolean canWin(String s) {
        if (s.length() <= 1) return false;
        char[] strArray = s.toCharArray();
        return canWinHelper(strArray);
    }

    private boolean canWinHelper(char[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                if (!canWinHelper(s.clone())) return true;
                s[i] = '+';
                s[i + 1] = '+';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "++++";
        System.out.println(s.canWin(str));
    }
}