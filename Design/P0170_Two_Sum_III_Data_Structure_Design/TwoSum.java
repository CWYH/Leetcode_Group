import java.util.*;

/**
 * 170. Two Sum III - Data Structure Design -- Easy
 */

class TwoSum {

    private HashMap<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int t = value - key;
            if (map.containsKey(t)) {
                if (t != key) return true;
                else if (map.get(t) >= 2) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */