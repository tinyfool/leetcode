package p0217;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {

        Solution solution = new Solution();
        assertTrue(solution.containsDuplicate(new int[]{1,2,3,1}));
    }

    @Test
    void test2() {

        Solution solution = new Solution();
        assertFalse(solution.containsDuplicate(new int[]{1,2,3,4}));
    }

    @Test
    void test3() {

        Solution solution = new Solution();
        assertTrue(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

}