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

//Runtime: 42 ms, faster than 25.70% of Java online submissions for Find K Pairs with Smallest Sums.
//Memory Usage: 79.4 MB, less than 7.41% of Java online submissions for Find K Pairs with Smallest Sums.
    
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if(nums1.length==0 || nums2.length==0)
            return null;
        PriorityQueue<List<Integer>> minheap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {

                return l1.get(0)+l1.get(1)-l2.get(0)-l2.get(1);
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer>  l = new ArrayList<>();
                l.add(nums1[i]);
                l.add(nums2[j]);
                minheap.add(l);
            }
        }
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i <k ; i++) {
            if(minheap.peek()!=null)
                results.add(minheap.poll());
        }
        return results;
    }
}
