/**
 * 292. Nim Game -- Easy
 */

class Solution {
    public boolean canWinNim(int n) {
        if (n <= 0) return false;
        if (n <= 3) return true;
        return !(n % 4 == 0);
    }
}