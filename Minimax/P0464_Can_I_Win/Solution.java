import java.util.*;
/**
 * 464. Can I Win -- Medium
 */

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int bits = 0;
        HashMap<Integer, Boolean> h = new HashMap<>();
        return canIWinHelper(maxChoosableInteger, desiredTotal, bits, h);
    }

    private boolean canIWinHelper(int m, int d, int bits, HashMap<Integer, Boolean> h) {
        if (d <= 0) return false;
        if (!h.containsKey(bits)) {
            for (int i = 1; i <= m; i++) {
                int t = 1 << (i - 1);
                if ((bits & t) != 0) continue;
                bits |= t;
                if (!canIWinHelper(m, d - i, bits, h)) {
                    bits -= t;
                    h.put(bits, true);
                    return true;
                }
                bits -= t;
            }
            h.put(bits, false);
        }
        return h.get(bits);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 5;
        int d = 50;
        System.out.println(s.canIWin(m, d));
    }
}