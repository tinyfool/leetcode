package p0349;

import java.util.HashMap;

//Runtime: 2 ms, faster than 98.29% of Java online submissions for Intersection of Two Arrays.
//Memory Usage: 37.3 MB, less than 87.72% of Java online submissions for Intersection of Two Arrays.

public class Soultion1 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> h1 = new HashMap<>();
        HashMap<Integer,Boolean> hr = new HashMap<>();
        for (int num:nums1
             ) {
            h1.put(num,true);
        }
        for (int num:nums2
             ) {
            if(h1.containsKey(num))
                hr.put(num,true);
        }
        int[] ret = new int[hr.size()];
        int i = 0;
        for (Integer num:hr.keySet()
             ) {
            ret[i] = num;
            i++;
        }
        return ret;
    }
}
