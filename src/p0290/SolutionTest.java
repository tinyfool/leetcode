package p0290;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test1() {
        assertTrue(solution.wordPattern("abba","dog cat cat dog"));
    }

    @Test
    void test2() {
        assertFalse(solution.wordPattern("abba","dog cat cat fish"));
    }

    @Test
    void test3() {
        assertFalse(solution.wordPattern("aaaa","dog cat cat dog"));
    }

    @Test
    void test4() {
        assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    void test5() {
        assertTrue(solution.wordPattern("e", "eukera"));
    }

    @Test
    void test6() {
        assertFalse(solution.wordPattern("", "beef"));
    }

}