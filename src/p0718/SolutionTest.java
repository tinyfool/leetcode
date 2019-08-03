package p0718;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(3,solution.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }

}