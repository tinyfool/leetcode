package p0219;

import helper.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest1 {


    Solution1 solution;
    @BeforeEach
    void setUp() {

        solution = new Solution1();
    }

    @Test
    void test1() {
        assertTrue(solution.containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }

    @Test
    void test2() {
        assertTrue(solution.containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }

    @Test
    void test3() {
        assertFalse(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }


    @Test
    void test4() {
        assertTrue(solution.containsNearbyDuplicate(new int[]{99,99},2));
    }

    @Test
    void test5() {
        assertTrue(solution.containsNearbyDuplicate(new int[]{2,2},3));
    }

    @Test
    void test6() {
        assertFalse(solution.containsNearbyDuplicate(new int[]{1},1));
    }

    @Test
    void test7() {
        assertFalse(solution.containsNearbyDuplicate(new int[]{1,2},2));
    }

    @Test
    void test8() {
        int[] data = DataLoader.intArrayFromfile("data/p0219/test8.txt");
        assertFalse(solution.containsNearbyDuplicate(data,35000));
    }

    @Test
    void test9() {
        assertFalse(solution.containsNearbyDuplicate(new int[]{1,2,1},0));
    }

    @Test
    void test10() {
        assertTrue(solution.containsNearbyDuplicate(new int[]{4,1,2,3,1,5},3));
    }
}