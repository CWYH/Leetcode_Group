import java.util.ArrayList;

import java.util.HashMap;

/**
 * 187. Repeated DNA Sequences -- Medium
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) return res;
        HashMap<String, Integer> h = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            h.put(str, h.getOrDefault(str, 0) + 1);
        }
        for (String str : h.keySet()) {
            if (h.get(str) > 1) {
                res.add(str);
            }
        }
        return res;
    }
}