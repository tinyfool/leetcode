package p0215;

import java.util.Arrays;

public class Solution1 {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {

        int[] a = {3,2,3,1,2,4,5,5,6};
        int[] b = {3,2,1,5,6,4};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findKthLargest(a,4));
        System.out.println(solution1.findKthLargest(b,2));
    }
}
