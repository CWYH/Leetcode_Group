import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums -- Medium
 */

class Solution {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return Integer.compare(o1.get(0) + o1.get(1),  o2.get(0) + o2.get(1));
//            }
//        });
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                pq.add(Arrays.asList(nums1[i], nums2[j]));
//            }
//        }
//        for (int i = 0; i < k && !pq.isEmpty(); i++) {
//            res.add(pq.poll());
//        }
//        return res;
//    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
                (a, b)->a.get(0) + a.get(1) - b.get(0) - b.get(1)
        );

        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }

        while (k > 0 && !pq.isEmpty()) {
            k--;
            List<Integer> tmp = pq.poll();
            res.add(Arrays.asList(tmp.get(0), tmp.get(1)));
            if (tmp.get(2) == nums2.length - 1) continue;
            pq.offer(Arrays.asList(tmp.get(0), nums2[tmp.get(2) + 1], tmp.get(2) + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> res = s.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> l : res) {
            System.out.println(l.get(0) + " " + l.get(1));
        }
    }
}