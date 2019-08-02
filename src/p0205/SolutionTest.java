package p0205;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertTrue(solution.isIsomorphic("egg","add"));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertFalse(solution.isIsomorphic("foo","bar"));
    }
    @Test

    void test3() {
        Solution solution = new Solution();
        assertTrue(solution.isIsomorphic("paper","title"));
    }
}