package p0218;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-26 09:21
 */
class Solution1Test {

    Solution1 solution1 = new Solution1();

    @Test
    void test1() {

        int[][] building = {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(2);
        one.add(10);
        result.add(one);

        one = new ArrayList<>();
        one.add(3);
        one.add(15);
        result.add(one);

        one = new ArrayList<>();
        one.add(7);
        one.add(12);
        result.add(one);

        one = new ArrayList<>();
        one.add(12);
        one.add(0);
        result.add(one);

        one = new ArrayList<>();
        one.add(15);
        one.add(10);
        result.add(one);

        one = new ArrayList<>();
        one.add(20);
        one.add(8);
        result.add(one);

        one = new ArrayList<>();
        one.add(24);
        one.add(0);
        result.add(one);

        assertEquals(result,solution1.getSkyline(building));
    }

    @Test
    void test2() {

        int[][] building = {
                {0,2,3},
                {2,5,3}};

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> one = new ArrayList<>();
        one.add(0);
        one.add(3);
        result.add(one);

        one = new ArrayList<>();
        one.add(5);
        one.add(0);
        result.add(one);

        assertEquals(result,solution1.getSkyline(building));
    }
}