package p0313;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 11:19
 */
class SolutionTest {


    //Input: n = 12, primes = [2,7,13,19]
    //Output: 32

    @Test
    void test() {

        Solution solution = new Solution();
        assertEquals(32,solution.nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }
}