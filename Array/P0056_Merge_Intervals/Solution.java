import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals -- Meidum
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });

        List<int[]> l = new ArrayList<>();
        l.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] back = l.get(l.size() - 1);
            if (back[1] < intervals[i][0]) {
                l.add(intervals[i]);
            } else {
                back[1] = Math.max(intervals[i][1], back[1]);
                l.set(l.size() - 1, back);
            }
        }

        int[][] res = new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}