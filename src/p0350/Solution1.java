package p0350;

import java.util.*;
//5ms
public class Solution1 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> h1 = new HashMap<>();
        HashMap<Integer,Integer> h2 = new HashMap<>();
        for (int num:nums1) {
            int count = h1.getOrDefault(num,0);
            count++;
            h1.put(num,count);
        }
        for (int num:nums2) {
            int count = h2.getOrDefault(num,0);
            count++;
            h2.put(num,count);
        }
        HashSet<Integer> keys = new HashSet<>();
        keys.addAll(h1.keySet());
        keys.addAll(h2.keySet());
        List<Integer> intersection = new ArrayList<>();
        for (Integer num:keys
             ) {
          int count = Math.min(h1.getOrDefault(num,0),h2.getOrDefault(num,0));
          for(int i=0;i<count;i++){
              intersection.add(num);
          }
        }
        int[] ret = new int[intersection.size()];
        int i = 0;
        for (Integer num:intersection
             ) {
            ret[i] = num;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] num1 = new int[]{1,2,2,1};
        int[] num2 = new int[]{2,2};
        Solution1 s1 = new Solution1();
        int[] intersection = s1.intersection(num1,num2);
        System.out.println(Arrays.toString(intersection));
    }
}
