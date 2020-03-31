/**
 * 424. Longest Repeating Character Replacement -- Medium
 */

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;
        int[] arr = new int[26];
        int left = 0;
        int right = 0;
        // int charMax = 1;
        // arr[s.charAt(0) - 'A'] = 1;
        // while (right < s.length()) {
        //     if (charMax + k >= right - left + 1) {
        //         right++;
        //         if (right >= s.length()) break;
        //         arr[s.charAt(right) - 'A']++;
        //         charMax = Math.max(charMax, arr[s.charAt(right) - 'A']);
        //     } else {
        //         right++;
        //         left++;
        //         if (right >= s.length()) break;
        //         arr[s.charAt(left - 1) - 'A']--;
        //         arr[s.charAt(right) - 'A']++;
        //         charMax = Math.max(charMax, arr[s.charAt(right) - 'A']);
        //     }
        // }

        int charMax = 0;
        for (; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;
            charMax = Math.max(charMax, arr[s.charAt(right) - 'A']);
            if (charMax + k < right - left + 1) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "AABABBA";
        int k = 1;
        System.out.println(s.characterReplacement(str, k));
    }
}