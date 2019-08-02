package p0202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void test1() {

        Solution solution = new Solution();
        assertTrue(solution.isHappy(19));
    }

    @Test
    void test2() {

        Solution solution = new Solution();
        assertTrue(solution.isHappy(7));
    }

    @Test
    void test3() {

        Solution solution = new Solution();
        assertTrue(solution.isHappy(1111111));
    }

    @Test
    void test4ForDeadLoop() {

        Solution solution = new Solution();
        assertFalse(solution.isHappy(4));
    }

}