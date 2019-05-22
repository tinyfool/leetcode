package p0053;

public class Solution2 { //Divide and Conquer


    public int maxSubArray(int[] nums) {

        int[] max = maximumSubarray(nums,0,nums.length-1);
        return max[2];
    }

    int[] maxCrossingSubarray(int[] A,int low, int mid, int high) {

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int sum = 0;
        int maxLeft = mid;
        int maxRight = mid+1;

        for (int i = mid;i>=low;i--) {
            sum += A[i];
            if(sum>leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int j = mid+1;j<=high;j++) {
            sum += A[j];
            if (sum>rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new int[]  {maxLeft,maxRight,leftSum+rightSum};
    }

    int[] maximumSubarray(int[] A, int low, int high) {

        if(high==low)
            return (new int[]{low,high,A[low]});
        else {
            int mid = (low+high)/2;
            int[] left = maximumSubarray(A,low,mid);
            int[] right = maximumSubarray(A,mid+1,high);
            int[] cross = maxCrossingSubarray(A,low,mid,high);
            if (left[2] >= right[2] && left[2] >= cross[2])
                return left;
            else if (right[2] >= left[2] && right[2] >= cross[2]) {
                return right;
            } else
                return cross;
        }
    }

    public static void main(String[] args){

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSubArray(nums));
    }
}
