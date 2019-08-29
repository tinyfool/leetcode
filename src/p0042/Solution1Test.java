package p0042;

import org.junit.jupiter.api.Test;
import p0036.Solution;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-29 12:22
 */
class Solution1Test {

    Solution1 solution1 = new Solution1();

    @Test
    void test() {

        int[] h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6,solution1.trap(h));
    }
}