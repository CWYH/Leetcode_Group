import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 763. Partition Labels -- Medium
 */

class Solution {
    public List<Integer> partitionLabels(String S) { 
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for (int i = 0; i != S.length(); i++) {
            char c = S.charAt(i);
            if (start[c - 'a'] == -1) start[c - 'a'] = i;
            end[c - 'a'] = i;
        }
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (start[i] >= 0) {
                l.add(Arrays.asList(start[i], end[i]));
            }
        }
        Collections.sort(l, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
        List<List<Integer>> Interval = new ArrayList<>();
        Interval.add(l.get(0));
        for (List<Integer> e : l) {
            List<Integer> back = Interval.get(Interval.size() - 1);
            if (back.get(1) < e.get(0)) {
                Interval.add(e);
            } else {
                back.set(1, Math.max(back.get(1), e.get(1)));
                Interval.set(Interval.size() - 1, back);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (List<Integer> e : Interval) {
            res.add(e.get(1) - e.get(0) + 1);
        }
        return res;
    }
}