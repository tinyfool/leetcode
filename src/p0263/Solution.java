package p0263;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 14:19
 */

//Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
//Memory Usage: 33.3 MB, less than 6.25% of Java online submissions for Ugly Number.

public class Solution {

    public boolean isUgly(int num) {

        if (num == 0)
            return false;
        while (num % 2 == 0) {
            num = num / 2;
        }
        if (num == 1)
            return true;
        while (num % 3 == 0) {
            num = num / 3;
        }
        if (num == 1)
            return true;
        while (num % 5 == 0) {
            num = num / 5;
        }
        if (num == 1)
            return true;
        return false;
    }
}
