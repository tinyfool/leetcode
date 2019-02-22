package p001;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeiqiang on 2016/10/16.
 */

public class Solution4 {

    public int[] twoSum(int[] nums, int target) {

        int[][] sortNums = new int[nums.length][2];
        for (int i=0;i<nums.length;i++) {
            sortNums[i][0] = nums[i];
            sortNums[i][1] = i;
        }
        Arrays.sort(sortNums,Comparator.comparing((int[] arr)->arr[0]));
        int left = 0;
        int right = sortNums.length-1;
        while(left<right) {

            if (sortNums[left][0]+sortNums[right][0]==target) {


                return new int[]{sortNums[left][1],
                        sortNums[right][1]};
            }

            if (sortNums[left][0]+sortNums[right][0]>target) {
                right--;
            } else {
                left++;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String [] args) {

        Solution4 s4 = new Solution4();
        int[] nums = new int[]{9,2,5,15,11,7};
        int[] ret = s4.twoSum(nums,9);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}