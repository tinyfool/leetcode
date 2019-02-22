package p001;
import java.util.HashMap;
import java.util.Map;

import static javafx.scene.input.KeyCode.M;

/**
 * Created by haopeiqiang on 2016/10/16.
 */

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        int[] x = new int[]{0,0};
        for (int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++) {

                if(nums[i]+nums[j]==target) {

                    x[0] = i;
                    x[1] = j;
                    return x;
               }
            }
        }
        return x;
    }

}