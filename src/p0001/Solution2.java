package p0001;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeiqiang on 2016/10/16.
 */

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] x = new int[]{0,0};
        for (int i = 0;i<nums.length;i++) {
            map.put(nums[i],i);
        }

        for (int j = 0;j<nums.length;j++) {

            int other = target - nums[j];

            if (map.containsKey(other)) {

                int pos = map.get(other);
                if (pos == j)
                    continue;
                x[0] = j;
                x[1] = pos;
                return x;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}