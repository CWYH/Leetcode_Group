/**
 * 274. H-index -- Medium
 */

// Bucket Sort

class Solution {
    public int hIndex(int[] citations) {
        final int N = citations.length;
        int[] buckets = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (citations[i] >= N) {
                buckets[N]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int cnt = 0;
        for (int i = N; i >= 0; i--) {
            cnt += buckets[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }
}

/**
// Binary Search

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        final int N = citations.length;
        int lo = 0, hi = citations[N - 1];
        int mid = 0;
        while (lo < hi) {
            if (lo + 1 == hi) {
                if (hi <= getNumGreater(citations, hi)) return hi;
                else return lo;
            }
            mid = (hi - lo) / 2 + lo;
            int num = getNumGreater(citations, mid);
            if (mid > num) {
                hi = mid - 1;
            } else if (mid < num) {
                lo = mid;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private int getNumGreater(int[] array, int a) {
        int index = Arrays.binarySearch(array, a);
        if (index == -1) return array.length;
        else if (index == -(array.length + 1)) return 0;
        else if (index >= 0) {
            while (index >= 1 && array[index - 1] == a)
                index--;
            return array.length - index;
        }
        else return array.length + index + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] citations = {0};
        System.out.println(s.hIndex(citations));
    }
}

 */