import java.util.HashMap;

/**
 * 405. Convert a Number to Hexadecimal -- Easy
 */

class Solution {

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, hex[(num & 15)]);
            num >>>= 4;     // 无符号右移
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num = -1;
        System.out.println(s.toHex(num));
    }
}