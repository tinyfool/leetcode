package p0015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//暂时跳过

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        for(int i = 0;i < nums.length;i++) {

            int other = 0-nums[i];
            twoSum(nums,other,i);
        }
        return null;
    }


    public List<List<Integer>> twoSum(int[] nums, int target,int without) {

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i<nums.length;i++) {

            if(i==without)
                continue;

            int other = target - nums[i];

            if (map.containsKey(other)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(map.get(other));
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
