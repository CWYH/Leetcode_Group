import java.util.*;

/**
 * 216. Combination Sum III -- Medium
 * 
 * Backtrack
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || k <= 0 || n <= 0) return res;
        List<Integer> tmpList = new ArrayList<>();
        DFS(k, n, res, tmpList, 1, 0);
        return res;
    }

    private void DFS(int k, int n, List<List<Integer>> res, List<Integer> tmpList, int num, int sum) {
        if (tmpList.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<Integer>(tmpList));
            }
        } else {
            for (int i = num; i <= 9; i++) {
                tmpList.add(i);
                sum += i;
                DFS(k, n, res, tmpList, i + 1, sum);
                sum -= i;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}