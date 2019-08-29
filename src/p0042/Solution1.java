package p0042;

import java.util.Stack;

//Runtime: 1 ms, faster than 98.21% of Java online submissions for Trapping Rain Water.
//Memory Usage: 37.7 MB, less than 95.89% of Java online submissions for Trapping Rain Water.

public class Solution1 {

    public int trap(int[] height) {
        int sum = 0;
        int[] left = new int[height.length + 1];
        int[] right = new int[height.length + 1];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i]>leftMax) {
                leftMax = height[i];
            }
            left[i+1] = leftMax;
            if(height[height.length-i-1]>rightMax) {
                rightMax = height[height.length-i-1];
            }
            right[height.length-i-1]=rightMax;
        }
        for (int i = 0; i <height.length ; i++) {
            if(height[i]<Math.min(left[i],right[i])) {
                sum+= Math.min(left[i],right[i])-height[i];
            }
        }
        return sum;
    }
}
