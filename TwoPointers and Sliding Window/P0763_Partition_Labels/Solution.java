import java.util.ArrayList;
import java.util.HashSet;

/**
 * 763. Partition Labels -- Medium
 */

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        for (; j < S.length(); j++) {
            char c = S.charAt(j);
            if (!set.contains(c)) {
                
            }
        }
    }
}