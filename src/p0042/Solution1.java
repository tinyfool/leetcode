package p0042;

import java.util.Stack;
//暂时跳过
public class Solution1 {

    public int trap(int[] height) {

        Stack<Integer> hs = new Stack<>();
        int sum = 0;
        int max = 0;
        for(int i = 1;i<height.length;i++) {

            if(height[i-1]>height[i]) {
                if(hs.size()>0) {
                    int left = hs.pop();
                    int low = Math.min(height[left],height[i-1]);
                    for(int j=left;j<i-1;j++) {
                        sum = sum + low - height[j];
                    }
                }
                hs.push(i-1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution1 s1 = new Solution1();
        System.out.println(s1.trap(h));
    }
}
