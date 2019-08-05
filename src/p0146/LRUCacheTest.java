package p0146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void test1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        assertEquals(1,cache.get(1));
        cache.put(3,3);
        assertEquals(-1,cache.get(2));
        cache.put(4,4);
        assertEquals(-1,cache.get(1));
        assertEquals(3,cache.get(3));
        assertEquals(4,cache.get(4));
    }

    @Test
    void test2() {
        LRUCache cache = new LRUCache(2);
        assertEquals(-1,cache.get(2));
        cache.put(2,6);
        assertEquals(-1,cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        assertEquals(2,cache.get(1));
        assertEquals(6,cache.get(2));
    }
}