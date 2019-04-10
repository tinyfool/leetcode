package p0053;

public class Solution2 { //Divide and Conquer


    public int maxSubArray(int[] nums) {

        int max = maxSubArrayFun(nums,0,nums.length);
        return max;
    }

    private int maxSubArrayFun(int[] A,int p,int r) {

        int q = r/2;
        int leftmax = maxSubArrayFun(A,p,q);
        int rightmax = maxSubArrayFun(A,q+1,r);
        int middlemax = maxMiddleArray(A,p,q,r);

        int max = Math.max(leftmax,rightmax);
        max = Math.max(max,middlemax);
        return max;
    }

    private int maxMiddleArray(int[] A,int p,int q,int r) {


        return 0;
    }

    public static void main(String[] args){

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSubArray(nums));
    }
}
