import java.util.*;

/**
 * 227. Basic Calculator -- Medium
 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> st_num = new Stack<>();
        Stack<Character> st_op = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (isNumber(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && isNumber(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (!st_op.empty() && (st_op.peek() == '*' || st_op.peek() == '/')) {
                    int a = st_num.pop();
                    char op = st_op.pop();
                    if (op == '*') num *= a;
                    if (op == '/') num = a / num;
                }
                if (!st_op.empty() && st_op.peek() == '-') {
                    num = -num;
                    st_op.pop();
                    st_op.push('+');
                }
                st_num.push(num);
            } else {
                st_op.push(s.charAt(i));
                i++;
            }
        }

        while (!st_op.empty()) {
            int a = st_num.pop();
            int b = st_num.pop();
            st_op.pop();
            a = a + b;
            st_num.push(a);
        }
        return st_num.peek();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "1-1+1";
        System.out.println(s.calculate(str));
    }
}