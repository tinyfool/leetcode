package p0204;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void test1() {

        Solution solution = new Solution();
        assertEquals(4,solution.countPrimes(10));
    }

    @Test
    void testTimeOut() {


        Solution solution = new Solution();
        assertEquals(41537,solution.countPrimes(499979));
    }
}