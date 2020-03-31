import java.util.*;

/**
 * 1245. Tree Diameter -- Medium
 */

class Solution {

    private int res = 0;
    public int treeDiameter(int[][] edges) {
        int N = edges.length;
        if (N == 1) return 0;
        List<Integer>[] neighbour = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            neighbour[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            neighbour[edges[i][0]].add(edges[i][1]);
            neighbour[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        dfs(0, neighbour, visited);

        return res;
    }

    private int dfs(int s, List<Integer>[] neighbour, boolean[] visited) {
        visited[s] = true;
        int max1 = 0;
        int max2 = 0;
        List<Integer> nei = neighbour[s];
        for (Integer e : nei) {
            if (visited[e]) continue;
            int m = dfs(e, neighbour, visited);
            if (m > max1) {
                max2 = max1;
                max1 = m;
            } else if (m >= max2) {
                max2 = m;
            }
        }
        res = Math.max(res, max1 + max2);

        return Math.max(max1, max2) + 1;
    }

    

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(s.treeDiameter(edges));
    }
}