package p0179;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

//Runtime: 4 ms, faster than 94.68% of Java online submissions for Largest Number.
//        Memory Usage: 36.1 MB, less than 88.61% of Java online submissions for Largest Number.

public class Solution1 {

    public String largestNumber(int[] nums) {

        final Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i<nums.length; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int l1 = o1.toString().length();
                int l2 = o2.toString().length();
                int s1 = o1*nTen(l2)+o2;
                int s2 = o2*nTen(l1)+o1;
                return s2-s1;
            }
        });
        if (sorted[0]==0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int num:sorted
             ) {
            sb.append(num);
        }
        return sb.toString();
    }

    private int nTen(int n) {
        int s = 1;
        for(int i=0;i<n;i++)
            s=s*10;
        return s;
    }

    public static void main(String[] args) {

        int[] numbs = new int[]{3,30,34,5,9};
        Solution1 s1 = new Solution1();
        System.out.println(s1.largestNumber(numbs));
    }
}
