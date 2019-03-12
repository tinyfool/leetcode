package p0001;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeiqiang on 2016/10/16.
 */

public class Solution3 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i<nums.length;i++) {

            int other = target - nums[i];

            if (map.containsKey(other)) {

                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}