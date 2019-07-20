package p0164;

import java.util.Arrays;

//Runtime: 2 ms, faster than 98.90% of Java online submissions for Maximum Gap.

public class Solution1 {

    public int maxiumGap(int[] nums) {

        if (nums.length<2)
            return 0;
        Arrays.sort(nums);
        int diff;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length-1; i++) {

            diff = nums[i+1]-nums[i];
            if(max<diff)
                max = diff;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] input = new int[]{3,6,9,1};
        Solution1 s1 = new Solution1();
        System.out.println(s1.maxiumGap(input));
    }
}
