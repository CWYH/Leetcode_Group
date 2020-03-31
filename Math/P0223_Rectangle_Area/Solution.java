/**
 * 223. Rectangle Area -- Medium
 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overLap = 0;
        if (E >= C || G <= A) overLap = 0;
        else if (F >= D || H <= B) overLap = 0;
        else {
            int X = Math.min(C, G) - Math.max(A, E);
            int Y = Math.min(D, H) - Math.max(B, F);
            overLap = X * Y;
        }

        return (D - B) * (C - A) + (H - F) * (G - E) - overLap;
    }
}