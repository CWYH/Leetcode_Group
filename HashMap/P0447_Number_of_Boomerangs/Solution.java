import java.util.HashMap;

/**
 * 447. Number of Boomerangs -- Easy
 */

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        final int M = points.length;
        if (M <= 0) return 0;
        final int N = points[0].length;
        if (N <= 0) return 0;

        int res = 0;

        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (i == j) continue;
                int d = getDistance(points, i, j);
                h.put(d, h.getOrDefault(d, 0) + 1);
            }

            for (Integer val : h.values()) {
                res += val * (val - 1);
            }
            h.clear();
        }

        return res;
    }

    private int getDistance(int[][] points, int i, int j) {
        int dx = points[i][0] - points[j][0];
        int dy = points[i][1] - points[j][1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(s.numberOfBoomerangs(points));
    }
}