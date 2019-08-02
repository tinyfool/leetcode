package p0347;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(list, solution.topKFrequent(new int[]{1,1,1,2,2,3},2));
    }

    @Test
    void test2() {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(list, solution.topKFrequent(new int[]{1},1));
    }


}