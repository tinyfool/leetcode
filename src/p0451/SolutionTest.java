package p0451;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals("eetr",solution.frequencySort("tree"));
    }

    @Test
    void test2() {
        assertEquals("cccaaa",solution.frequencySort("cccaaa"));
    }

    @Test
    void test3() {
        assertEquals("bbaA",solution.frequencySort("Aabb"));
    }
}