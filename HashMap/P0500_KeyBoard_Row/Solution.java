import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 500. KeyBoard Row -- Easy
 */

class Solution {
    private HashMap<Character, Integer> h;

    Solution() {
        h = new HashMap<>();
        char[] c0 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] c1 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] c2 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        for (int i = 0; i < c0.length; i++) {
            h.put(c0[i], 0);
            h.put((char)(c0[i] - 'A' + 'a'), 0);
        }
        for (int i = 0; i < c1.length; i++) {
            h.put(c1[i], 1);
            h.put((char)(c1[i] - 'A' + 'a'), 1);
        }
        for (int i = 0; i < c2.length; i++) {
            h.put(c2[i], 2);
            h.put((char)(c2[i] - 'A' + 'a'), 2);
        }
    }

    public String[] findWords(String[] words) {
        List<String> arr = new ArrayList<>();
        for (String str : words) {
            int l = -1;
            boolean found = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (l == -1) {
                    l = h.get(c);
                } else if (h.get(c) != l) {
                    found = false;
                    break;
                }
            }
            if (found) arr.add(str);
        }
        String[] res = arr.toArray(new String[arr.size()]);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = s.findWords(words);
        for (String str : res) {
            System.out.println(str);
        }
    }
}