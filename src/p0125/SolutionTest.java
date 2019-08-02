package p0125;

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
    void test1 () {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void test2 () {
        assertFalse(solution.isPalindrome("race a car"));
    }

}