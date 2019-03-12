package p0004;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0;
        int p2 = 0;
        int len = nums1.length+nums2.length;
        //int[] num = new int[len];
        double median = 0.0;
        int m1 = 0, m2 = 0;
        int odd = 0;
        if (len%2 != 0)
            odd = 1;
        int half = len/2;
        int current = 0;
        for(int i = 0;i<len;i++) {

            if(p1==nums1.length){

                current = nums2[p2];
                p2++;
            } else  if (p2 == nums2.length) {

                current = nums1[p1];
                p1++;
            } else if(nums1[p1]<nums2[p2]) {

                current = nums1[p1];
                p1++;
            }else {

                current = nums2[p2];
                p2++;
            }

            if (i==half && odd==1) {
                return (double)current;
            }

            if(odd==0) {
                if(i==half-1)
                    m1 = current;
                if(i==half)
                    m2 = current;
            }
        }

        median = (m1+m2)/2.0;
        return median;
    }

    public static void main(String [] args) {

        test1();
        test2();
        test3();
    }

    public static void test1() {

        Solution2 solution2 = new Solution2();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution2.findMedianSortedArrays(nums1,nums2));
    }

    public static void test2() {

        Solution2 solution2 = new Solution2();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution2.findMedianSortedArrays(nums1,nums2));
    }

    public static void test3() {

        Solution2 solution2 = new Solution2();
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println(solution2.findMedianSortedArrays(nums1,nums2));
    }

}
