package p0239;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 13:41
 */
class SolutionTest {

    Solution solution = new Solution();
    Solution2 solution2 = new Solution2();

    @Test
    void test1() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] excepts = new int[]{3,3,5,5,6,7};
        assertArrayEquals(excepts,solution.maxSlidingWindow(nums,3));
        assertArrayEquals(excepts,solution2.maxSlidingWindow(nums,3));
    }
}