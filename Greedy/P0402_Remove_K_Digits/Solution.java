import java.util.*;

/**
 * 402. Remove K Digits -- Medium
 */

/**
 * 单调栈
 * 
 * 维护一个递增栈，但当前元素小于栈顶元素，则移掉栈顶元素。
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k <= 0) return num;
        Stack<Character> stk = new Stack<>();
        int i = 0;
        for (i = 0; i < num.length(); i++) {
            while (k > 0 && !stk.empty() && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }
        if (k > 0) {
            while (k-- > 0) stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.insert(0, stk.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String num = "1432219";
        int k = 3;
        System.out.println(s.removeKdigits(num, k));
    }
}

/**
class Solution {
    public String removeKdigits(String num, int k) {
        return removeKdigits(new StringBuilder(num), k).toString();
    }

    private StringBuilder removeKdigits(StringBuilder sb, int k) {
        if (k >= sb.length()) return new StringBuilder("0");
        if (k <= 0) return sb;
        boolean hasDel = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                hasDel = true;
                break;
            }
        }
        if (!hasDel) sb.deleteCharAt(sb.length() - 1);
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return removeKdigits(sb, k - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String num = "1432219";
        int k = 3;
        System.out.println(s.removeKdigits(num, k));
    }
}
 */