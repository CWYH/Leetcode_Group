/**
 * 76. Minimum Window Substring -- Hard
 */

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] window = new int[256];
        int[] tarr = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tarr[t.charAt(i)]++;
        }
        int appeared = 0;
        int left = 0, right = 0;
        int minLen = s.length() + 1;
        String res = new String();
        for (; right < s.length(); right++) {
            char cur = s.charAt(right);
            window[cur]++;
            if (tarr[cur] > 0 && window[cur] <= tarr[cur]) {
                appeared++;
            }

            if (appeared == t.length()) {
                while (left < right) {
                    char l = s.charAt(left);
                    if (tarr[l] == 0) {
                        left++;
                        window[l]--;
                    } else if (window[l] > tarr[l]) {
                        left++;
                        window[l]--;
                    } else if (window[l] == tarr[l]) {
                        break;
                    }
                }

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "a";
        String t = "a";
        String res = s.minWindow(str, t);
        System.out.println(res);
    }
}