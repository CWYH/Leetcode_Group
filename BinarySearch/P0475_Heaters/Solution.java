import java.utils.Arrays;

/**
 * 475. Heaters -- Medium
 */

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -1 - pos;
                if (pos == 0) res = Math.max(res, heaters[0] - house);
                else if (pos == heaters.length) res = Math.max(res, house - heaters[heaters.length - 1]);
                else res = Math.max(res, Math.min(house - heaters[pos - 1], heaters[pos] - house));
            }
        }
        return res;
    }
}