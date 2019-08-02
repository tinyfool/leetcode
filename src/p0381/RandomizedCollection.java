package p0381;

import java.util.*;

public class RandomizedCollection {

    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {

        int count = map.getOrDefault(val, 0);
        map.put(val, count + 1);
        list.add(val);
        if (count == 0)
            return true;
        else
            return false;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        int count = map.getOrDefault(val, 0);

        if (count > 0) {

            map.put(val, count - 1);
            for (int i = 0; i < list.size(); i++) {
                if (val == list.get(i)) {
                    list.remove(i);
                    break;
                }
            }
            return true;
        } else
            return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {

        Random rand = new Random();
        int size = list.size();
        int index = rand.nextInt(size);
        return list.get(index);
    }

}
