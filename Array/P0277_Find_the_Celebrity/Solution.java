/**
 * 277. Find the Celebrity -- Medium
 * 
 * Micorsoft
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 0;

        for (int i = 0; i < n; i++) {
            boolean knowNone = true;
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    knowNone = false;
                    break;
                }
            }
            if (knowNone) {
                boolean allKnow = true;
                for (int j = 0; j < n; j++) {
                    if (!knows(j, i)) {
                        allKnow = false;
                        break;
                    }
                }
                if (allKnow) return i;
            }
        }

        return -1;
    }
}