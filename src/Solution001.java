/**
 * Created by haopeiqiang on 2016/10/16.
 */

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {

        int[] x = new int[]{0,0};
        for (int i=0;i<nums.length;i++){

            for(int j=0;j<nums.length;j++) {

                if(i!=j) {

                    if(nums[i]+nums[j]==target) {

                        x[0] = i;
                        x[1] = j;
                        return x;
                    }

                }
            }
        }
        return x;
    }

}