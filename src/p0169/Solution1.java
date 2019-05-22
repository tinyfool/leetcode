package p0169;

import java.util.HashMap;

//hashmap approach
public class Solution1 {

    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        int max = 0;
        int maxNum = 0;
        for (int key:count.keySet()) {
            int nc = count.getOrDefault(key,0);
            if (nc>max) {
                max = nc;
                maxNum = key;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {

//        Input: [3,2,3]
//        Input: [2,2,1,1,1,2,2]
        int[] a = {3,2,3};
        int[] b = {2,2,1,1,1,2,2};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.majorityElement(a));
        System.out.println(solution1.majorityElement(b));
    }
}
