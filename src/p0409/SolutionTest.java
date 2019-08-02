package p0409;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        assertEquals(7,solution.longestPalindrome("abccccdd"));
    }
}