package p0706;
//Runtime: 69 ms, faster than 33.97% of Java online submissions for Design HashMap.
//Memory Usage: 60.1 MB, less than 16.36% of Java online submissions for Design HashMap.

public class MyHashMap {

    /** Initialize your data structure here. */
    int[] mem = new int[1000000];
    public MyHashMap() {
        for(int i=0;i<1000000;i++){
            mem[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        mem[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return mem[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        mem[key] = -1;
    }
}
