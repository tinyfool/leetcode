package p0594;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        assertEquals(5,solution.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}