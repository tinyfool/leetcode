package p0136;

import java.util.HashMap;

//Runtime: 10 ms, faster than 10.55% of Java online submissions for Single Number.
//Memory Usage: 39.8 MB, less than 95.40% of Java online submissions for Single Number.

public class Solution {

    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {

            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num:map.keySet()) {
            if(map.get(num)==1)
                return num;
        }
        return 0;
    }
}
