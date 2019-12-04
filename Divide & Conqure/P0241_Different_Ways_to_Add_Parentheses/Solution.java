import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses -- Medium
 *
 * Divide and Conquer
 */

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                String str1 = input.substring(0, i);
                String str2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(str1);
                List<Integer> res2 = diffWaysToCompute(str2);
                for (Integer e1 : res1) {
                    for (Integer e2 : res2) {
                        switch (c) {
                            case '+': res.add(e1 + e2); break;
                            case '-': res.add(e1 - e2); break;
                            case '*': res.add(e1 * e2); break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "2*3-4*5"; // "2-1-1";
        List<Integer> res = s.diffWaysToCompute(input);
        for (Integer e : res) {
            System.out.println(e);
        }
    }
}