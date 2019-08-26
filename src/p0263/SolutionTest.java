package p0263;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 14:19
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test() {

        assertTrue(solution.isUgly(3));
        assertTrue(solution.isUgly(8));
        assertFalse(solution.isUgly(14));
    }
}