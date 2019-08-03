package p0705;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
//int[]
//Runtime: 60 ms, faster than 57.44% of Java online submissions for Design HashSet.
//Memory Usage: 58.5 MB, less than 25.00% of Java online submissions for Design HashSet.
//Bool
//Runtime: 57 ms, faster than 92.84% of Java online submissions for Design HashSet.
//Memory Usage: 57.6 MB, less than 37.04% of Java online submissions for Design HashSet.
//BitSet
//Runtime: 57 ms, faster than 92.84% of Java online submissions for Design HashSet.
//Memory Usage: 52.7 MB, less than 94.44% of Java online submissions for Design HashSet.
class MyHashSet {

    BitSet mem = new BitSet(1000000);
    public MyHashSet() {

    }

    public void add(int key) {
        mem.set(key);
    }

    public void remove(int key) {
        mem.clear(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        return mem.get(key);
    }
}
