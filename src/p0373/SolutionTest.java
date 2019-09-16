package p0373;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 13:01
 */
class SolutionTest {

    Solution solution = new Solution();
    Solution1 solution1 = new Solution1();
    Solution2 solution2 = new Solution2();

    @Test
    void test1() {
        //Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        //Output: [[1,2],[1,4],[1,6]]

        List<List<Integer>> excepts = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(1);
        pair.add(2);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(4);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(6);
        excepts.add(pair);
        assertEquals(excepts,solution.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));
        //assertEquals(excepts,solution1.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));
        assertEquals(excepts,solution2.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));

    }

    @Test
    void test2() {
        //Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        //Output: [1,1],[1,1]

        List<List<Integer>> excepts = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(1);
        pair.add(1);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(1);
        excepts.add(pair);

        assertEquals(excepts,solution.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
        //assertEquals(excepts,solution1.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
        assertEquals(excepts,solution2.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
    }

    @Test
    void test3() {
        //Input: nums1 = [1,2], nums2 = [3], k = 2
        //Output: [1,3],[2,3]

        List<List<Integer>> excepts = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(1);
        pair.add(3);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(2);
        pair.add(3);
        excepts.add(pair);

        assertEquals(excepts,solution.kSmallestPairs(new int[]{1,2},new int[]{3},2));
        //assertEquals(excepts,solution1.kSmallestPairs(new int[]{1,2},new int[]{3},2));
        assertEquals(excepts,solution2.kSmallestPairs(new int[]{1,2},new int[]{3},2));
    }


    @Test
    void test4() {
        //Input: nums1 = [1,2], nums2 = [3], k = 2
        //Output: [1,3],[2,3]

        List<List<Integer>> excepts = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(1);
        pair.add(1);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(1);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(2);
        excepts.add(pair);


        pair = new ArrayList<>();
        pair.add(1);
        pair.add(2);
        excepts.add(pair);


        pair = new ArrayList<>();
        pair.add(2);
        pair.add(1);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(3);
        excepts.add(pair);


        pair = new ArrayList<>();
        pair.add(2);
        pair.add(2);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(1);
        pair.add(3);
        excepts.add(pair);

        pair = new ArrayList<>();
        pair.add(2);
        pair.add(3);
        excepts.add(pair);

        assertEquals(excepts,solution.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},10));
        //assertEquals(excepts,solution1.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},10));
        Collections.sort(excepts, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                return integers.get(0).compareTo(t1.get(0));
            }
        });
        List<List<Integer>> result = solution2.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},10);
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                return integers.get(0).compareTo(t1.get(0));
            }
        });
        assertEquals(excepts,result);
    }
}