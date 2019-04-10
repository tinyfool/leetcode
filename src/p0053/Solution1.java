package p0053;

public class Solution1 {


    public int maxSubArray(int[] nums) {

        return maxStart(0,nums);
    }

    private int maxStart(int pos,int[] nums) {

        int max = Integer.MIN_VALUE;
        int s = 0;
        if(pos==nums.length-1)
            return nums[pos];
        for (int i = pos; i < nums.length;i++) {
            s+=nums[i];
            if(s>max)
                max = s;
        }
        max = Math.max(max,maxStart(pos+1,nums));
        return max;
    }

    public static void main(String[] args){

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxSubArray(nums));
    }
}
