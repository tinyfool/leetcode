package p0239;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 13:40
 */

//Runtime: 38 ms, faster than 20.72% of Java online submissions for Sliding Window Maximum.
//Memory Usage: 39.9 MB, less than 93.75% of Java online submissions for Sliding Window Maximum.
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==0)
            return new int[0];
        int [] ret = new int[nums.length-k+1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i <nums.length ; i++) {
            maxHeap.add(nums[i]);
            if(i>=k-1){
                ret[i-k+1] = maxHeap.peek();
                maxHeap.remove(nums[i-k+1]);
            }
        }
        return ret;
    }
}
