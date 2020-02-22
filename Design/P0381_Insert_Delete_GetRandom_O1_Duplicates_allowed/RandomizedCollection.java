import java.util.*;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed -- Hard
 */

class RandomizedCollection {

    private List<Integer> list = new ArrayList<>();
    private HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        boolean notContained = true;
        if (map.containsKey(val)) notContained = false;
        else map.put(val, new HashSet<Integer>());
        HashSet<Integer> hs = map.get(val);
        hs.add(list.size() - 1);
        map.put(val, hs);
        return notContained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        HashSet<Integer> hs = map.get(val);
        Iterator<Integer> it = hs.iterator();
        int index = it.next();
        if (list.get(list.size() - 1) == val) {  // list的最后一个数为val直接删除最后一个数
            index = list.size() - 1;
        }
        if (index != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            HashSet<Integer> hslast = map.get(last);
            hslast.remove(list.size() - 1);
            hslast.add(index);
            map.put(last, hslast);
        }
        
        list.remove(list.size() - 1);

        hs.remove(index);
        if (hs.isEmpty()) map.remove(val);
        else map.put(val, hs);

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.out.println(rc.insert(4));
        System.out.println(rc.insert(3));
        System.out.println(rc.insert(4));
        System.out.println(rc.insert(2));
        System.out.println(rc.insert(4));
        System.out.println(rc.remove(4));
        System.out.println(rc.remove(3));
        System.out.println(rc.remove(4));
        System.out.println(rc.remove(4));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */