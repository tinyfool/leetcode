package p0705;

import org.junit.jupiter.api.Test;
import p0036.Solution;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    Solution solution = new Solution();

    // * Your MyHashSet object will be instantiated and called as such:
    // * MyHashSet obj = new MyHashSet();
    // * obj.add(key);
    // * obj.remove(key);
    // * boolean param_3 = obj.contains(key);

    @Test
    void test1() {

        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        assertTrue(hashSet.contains(1));    // returns true
        assertFalse(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        assertTrue(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        assertFalse(hashSet.contains(2));    // returns false (already removed)
    }
}