package p0645;

import java.util.HashMap;
//Runtime: 20 ms, faster than 19.15% of Java online submissions for Set Mismatch.
//Memory Usage: 37.9 MB, less than 98.72% of Java online submissions for Set Mismatch.

public class Solution {

    public int[] findErrorNums(int[] nums) {

        int ret[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > 1)
                ret[0] = num;
        }
        int n = nums.length;
        for (int i = 1; i < n+1; i++) {
            if (!map.containsKey(i))
                ret[1] = i;
        }
        return ret;
    }
}
