package p0295;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 11:01
 */
class MedianFinderTest {


    @Test
    void test1(){

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.5,medianFinder.findMedian());
        medianFinder.addNum(4);
        assertEquals(3,medianFinder.findMedian());
    }

}