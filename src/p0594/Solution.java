package p0594;

import java.util.HashMap;

//Runtime: 31 ms, faster than 49.90% of Java online submissions for Longest Harmonious Subsequence.
//Memory Usage: 39.8 MB, less than 98.53% of Java online submissions for Longest Harmonious Subsequence.

public class Solution {


    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : freqMap.keySet()) {

            int c1 = freqMap.getOrDefault(num, 0);
            int c2 = freqMap.getOrDefault(num+1, 0);
            if (c2 != 0) {
                if (max < c1 + c2)
                    max = c1 + c2;
            }
        }
        return max;
    }

}
