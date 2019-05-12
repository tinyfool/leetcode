package CLRS.DivideAndConquer;

public class MaximumSubarray {


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

    public static void main(String[] args) {

        int[] A = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int [] result = maximumSubarray.maximumSubarray(A,0,A.length-1);
        System.out.println(result);
    }
}
