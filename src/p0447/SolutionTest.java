package p0447;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution solution = new Solution();

    @Test
    void test1() {

        assertEquals(2,solution.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
    }
}