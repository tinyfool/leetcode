package p0373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 12:58
 */

//wrong solution
public class Solution1 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if (nums1.length == 0 || nums2.length == 0)
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(nums1[0]);
        l.add(nums2[0]);
        results.add(l);
        int i1 = 0;
        int i2 = 0;
        while (results.size() < k && i1 < nums1.length && i2 < nums2.length) {
            if(i1+1==nums1.length&&i2+1==nums2.length)
                return results;
            List<Integer> nl = new ArrayList<>();
            if(i1+1==nums1.length) {
                nl.add(nums1[i1]);
                nl.add(nums2[++i2]);
                results.add(nl);
                continue;
            }

            if(i2+1==nums2.length) {
                nl.add(nums1[++i1]);
                nl.add(nums2[i2]);
                results.add(nl);
                continue;
            }

            if (nums1[i1] + nums2[i2 + 1] <= nums1[i1 + 1] + nums2[i2]) {
                nl.add(nums1[i1]);
                nl.add(nums2[++i2]);
                results.add(nl);
            } else {
                nl.add(nums1[++i1]);
                nl.add(nums2[i2]);
                results.add(nl);
            }
        }
        return results;
    }
}
