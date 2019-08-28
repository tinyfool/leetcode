package p0295;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 10:47
 */

//Runtime: 110 ms, faster than 73.71% of Java online submissions for Find Median from Data Stream.
//Memory Usage: 67.2 MB, less than 50.85% of Java online submissions for Find Median from Data Stream.

public class MedianFinder {
    PriorityQueue<Integer> top;
    PriorityQueue<Integer> bottom;
    public MedianFinder() {
        top = new PriorityQueue<>();
        bottom = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if(bottom.size()==0 || num<bottom.peek()){
            bottom.add(num);
        }else {
            top.add(num);
        }
        if(bottom.size()-top.size()>1) {
            top.add(bottom.poll());
        }
        if(top.size()>bottom.size()){
            bottom.add(top.poll());
        }
    }

    public double findMedian() {
        if((top.size()+bottom.size())%2==1) {
            return bottom.peek();
        }else {
            return (bottom.peek()+top.peek())/2.0;
        }
    }
}
