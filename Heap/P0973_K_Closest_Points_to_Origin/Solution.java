import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin -- Medium
 * 
 * Amazon
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -getDistance(o1) + getDistance(o2);    // 大顶堆
            }
        });

        for (int i = 0; i < points.length; i++) {
            if (pq.size() < K) {
                pq.offer(points[i]);
            } else {
                int[] p = pq.peek();
                if (getDistance(p) > getDistance(points[i])) {
                    pq.poll();
                    pq.offer(points[i]);
                }
            }
        }

        int[][] res = new int[K][2];
        for (int i = K - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    private int getDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] res = s.kClosest(points, K);
        for (int i = 0; i < K; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}