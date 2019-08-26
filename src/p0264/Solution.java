package p0264;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 14:29
 */

//Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number II.
//Memory Usage: 33.4 MB, less than 95.45% of Java online submissions for Ugly Number II.
public class Solution {

    static List<Integer> nums = new ArrayList<>();

    static int i2 = 0;
    static int i3 = 0;
    static int i5 = 0;
    public int nthUglyNumber(int n) {
        if(nums.size()==0)
            nums.add(1);
        while (nums.size()<n){
            int next2 = nums.get(i2)*2;
            int next3 = nums.get(i3)*3;
            int next5 = nums.get(i5)*5;
            int next = Math.min(Math.min(next2,next3),next5);
            if(next==next2) i2++;
            if(next==next3) i3++;
            if(next==next5) i5++;
            nums.add(next);
        }
        return nums.get(n-1);
    }
}
