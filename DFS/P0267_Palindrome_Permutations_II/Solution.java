import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 267. Palindrome Permutation II -- Medium
 * 
 * Micorsoft, Uber, Amazon
 * 
 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
 * Return an empty list if no palindromic permutation could be form.
 * 
 * Example 1:
 * 
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 * 
 * Input: "abc"
 * Output: []
 * 
 */


class Solution {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> keys = new ArrayList<>();
        int oddNum = 0;
        char Single = ' ';
        for (char c : h.keySet()) {
            keys.add(c);
            if (h.get(c) % 2 != 0) {
                oddNum++;
                Single = c;
            }
            if (oddNum > 1) return new ArrayList<>();
        }
        Collections.sort(keys);
        int len = 0;
        for (char key : keys) {
            h.put(key, h.get(key) / 2);
            len += h.get(key);
        }

        ArrayList<StringBuffer> arr = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        permutations(keys, h, len, arr, sb);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            StringBuffer sbr = new StringBuffer();
            if (Single == ' ') {
                sbr.append(arr.get(i));
                sbr.append(arr.get(i).reverse());
            } else {
                sbr.append(arr.get(i));
                sbr.append(Single);
                sbr.append(arr.get(i).reverse());
            }
            res.add(sbr.toString());
        }
        return res;
    }

    public void permutations(ArrayList<Character> keys, HashMap<Character, Integer> h, int len,
            ArrayList<StringBuffer> arr, StringBuffer sb) {
        if (sb.length() == len) {
            arr.add(new StringBuffer(sb));
        } else {
            for (int i = 0; i < keys.size(); i++) {
                char c = keys.get(i);
                if (h.get(c) > 0) {
                    sb.append(c);
                    h.put(c, h.get(c) - 1);
                    permutations(keys, h, len, arr, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    h.put(c, h.get(c) + 1);
                }
            }
        }
    }

}