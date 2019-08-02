package p0387;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution solution = new Solution();

    @Test
    void test1() {

        assertEquals(0, solution.firstUniqChar("leetcode"));
    }

    @Test
    void test2() {

        assertEquals(2, solution.firstUniqChar("loveleetcode"));
    }
}