package p0169;

import java.util.HashMap;

//divide and conquer approach
public class Solution2 {

    public int majorityElement(int[] nums) {

        return majorityElemnetFun(nums,0,nums.length-1);
    }

    int majorityElemnetFun(int[] nums,int lo,int hi) {

        if (lo==hi)
            return nums[lo];
        int mid = (hi-lo)/2+lo;
        int left = majorityElemnetFun(nums,lo,mid);
        int right = majorityElemnetFun(nums,mid+1,hi);
        if(left==right)
            return left;
        int leftCount = countInSubarray(nums, left, lo, hi);
        int rightCount = countInSubarray(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    int countInSubarray(int[] nums,int num,int start,int end) {

        int count = 0;
        for(int i = start;i<=end;i++) {
            if (nums[i]==num)
                count++;
        }
        return count;
    }


    public static void main(String[] args) {

//        Input: [3,2,3]
//        Input: [2,2,1,1,1,2,2]
        int[] a = {3,2,3};
        int[] b = {2,2,1,1,1,2,2};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.majorityElement(a));
        System.out.println(solution2.majorityElement(b));
    }
}
