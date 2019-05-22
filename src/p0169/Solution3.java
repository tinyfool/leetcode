package p0169;

import java.util.Arrays;

//sort first approach
public class Solution3 {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int current = 0;
        double count = 0.0;
        double half = nums.length/2.0;
        for(int i=0;i<nums.length;i++) {
            if (current!=nums[i]) {
                current = nums[i];
                count =0;
            }
            count++;
            if (count>half)
                return current;
        }
        return 0;
    }


    public static void main(String[] args) {

//        Input: [3,2,3]
//        Input: [2,2,1,1,1,2,2]
        int[] a = {3,2,3};
        int[] b = {2,2,1,1,1,2,2};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.majorityElement(a));
        System.out.println(solution3.majorityElement(b));
    }
}
