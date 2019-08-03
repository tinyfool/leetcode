package p0645;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1(){

        int[] ret = solution.findErrorNums(new int[]{1,2,2,4});
        assertEquals(2,ret[0]);
        assertEquals(3,ret[1]);
    }

    @Test
    void test2(){

        int[] ret = solution.findErrorNums(new int[]{1,1});
        assertEquals(1,ret[0]);
        assertEquals(2,ret[1]);
    }

}