import java.util.List;

/**
 * 293. Flip Game -- Easy
 */

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 1) return res;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(s.substring(0, i));
                sb.append("--");
                sb.append(s.substring(i + 2));
                res.add(sb.toString());
            }
        }
        return res;
    }
}