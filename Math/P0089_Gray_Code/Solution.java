import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89. Gray Code -- Medium
 */

class Solution {
    public List<Integer> grayCode(int n) {
        if (n < 0) return new ArrayList<>();
        if (n == 0) return Arrays.asList(0);
        if (n == 1) return Arrays.asList(0, 1);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0); res.add(1);
        int number = 2;
        for (int i = 2; i <= n; i++) {
            for (int j = number - 1; j >= 0; j--) {
                res.add(res.get(j) + number);
            }
            number <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 8;
        List<Integer> res = s.grayCode(n);
        for (Integer e : res) {
            System.out.println(e);
        }
    }
}