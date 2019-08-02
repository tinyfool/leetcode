package p0380;

import java.util.*;
//Runtime: 109 ms, faster than 14.22% of Java online submissions for Insert Delete GetRandom O(1).
//Memory Usage: 51.3 MB, less than 16.98% of Java online submissions for Insert Delete GetRandom O(1).

public class RandomizedSet {

    /** Initialize your data structure here. */
    Set<Integer> set = new HashSet<>();
    ArrayList<Integer> list = new ArrayList<>();
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)) {
            set.remove(val);
            list.remove((Integer)val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(set.size());
        return list.get(index);
    }
}
