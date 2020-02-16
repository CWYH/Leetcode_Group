import java.util.*;
/**
 * 281. Zigzag Iterator -- Medium
 */

public class ZigzagIterator {

    private List<List<Integer>> v = new ArrayList<>();
    private int index;
    private List<Integer> posArray = new ArrayList<>();
    private int num;      // the number of remaining integers 

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v.add(v1);
        v.add(v2);
        index = 0;
        for (int i = 0; i < v.size(); i++) {
            posArray.add(0);
            num += v.get(i).size();
        }
    }

    public int next() {
        while (posArray.get(index) >= v.get(index).size()) {
            index = (index + 1) % v.size();
        }
        int res = v.get(index).get(posArray.get(index));
        num--;
        posArray.set(index, posArray.get(index) + 1);
        index = (index + 1) % v.size();
        return res;
    }

    public boolean hasNext() {
        return num > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */