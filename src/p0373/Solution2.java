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
public class Solution2 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if (nums1.length == 0 || nums2.length == 0)
            return new ArrayList<>();
                int fullength = Math.max(nums1.length, nums2.length);
                PriorityQueue<List<Integer>> minheap = new PriorityQueue<>(new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> l1, List<Integer> l2) {

                        return l1.get(0) + l1.get(1) - l2.get(0) - l2.get(1);
            }
        });
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length || i2 < nums2.length) {

            if(i1<nums1.length)
            {
                for (int j1 = i2; j1 < nums2.length; j1++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums1[i1]);
                    l.add(nums2[j1]);
                    minheap.add(l);
                }
                i1++;
            }

            if(i2<nums2.length) {

                for (int j2 = i1; j2 < nums1.length; j2++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums1[j2]);
                    l.add(nums2[i2]);
                    minheap.add(l);
                }
                i2++;
            }

            if (minheap.size() >= k)
                break;
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (minheap.peek() != null)
                results.add(minheap.poll());
        }
        return results;
    }
}
