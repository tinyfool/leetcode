/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0;
        int p2 = 0;
        int len = nums1.length+nums2.length;
        int[] num = new int[len];
        double median = 0.0;
        for(int i = 0;i<len;i++) {

            if(p1==nums1.length) {

                num[i] = nums2[p2];
                p2++;
                continue;
            }

            if(p2==nums2.length) {

                num[i] = nums1[p1];
                p1++;
                continue;
            }

            if(nums1[p1]<nums2[p2]) {

                num[i] = nums1[p1];
                p1++;
            }else {

                num[i] = nums2[p2];
                p2++;
            }
        }
        if(len%2 == 0) {

            int index = len/2;
            median = (num[index-1]+num[index])/2.0;
        }else {

            int index = len/2;
            median = num[index];
        }
        return median;
    }

    public static void main(String [] args) {

        test1();
        test2();
        test3();
    }

    public static void test1() {

        Solution004 s4 = new Solution004();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(s4.findMedianSortedArrays(nums1,nums2));
    }

    public static void test2() {

        Solution004 s4 = new Solution004();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(s4.findMedianSortedArrays(nums1,nums2));
    }

    public static void test3() {

        Solution004 s4 = new Solution004();
        int[] nums1 = {};
        int[] nums2 = {2,3};
        System.out.println(s4.findMedianSortedArrays(nums1,nums2));
    }

}
