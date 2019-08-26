package p0264;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 14:29
 */
class SolutionTest {

    Solution solution = new Solution();
    @Test
    void test() {

        assertEquals(12,solution.nthUglyNumber(10));
    }
}