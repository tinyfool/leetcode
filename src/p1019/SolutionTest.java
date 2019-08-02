package p1019;

import helper.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class SolutionTest {

    @Test
    void test1() {

        ListNode node = ListNode.fromArray(new int[]{2,1,5});
        Solution solution = new Solution();
        int[] ret = solution.nextLargerNodes(node);
        assertEquals(5,ret[0]);
        assertEquals(5,ret[1]);
        assertEquals(0,ret[2]);
    }

    @Test
    void test2() {

        ListNode node = ListNode.fromArray(new int[]{2,7,4,3,5});
        Solution solution = new Solution();
        int[] ret = solution.nextLargerNodes(node);
        assertEquals(7,ret[0]);
        assertEquals(0,ret[1]);
        assertEquals(5,ret[2]);
        assertEquals(5,ret[3]);
        assertEquals(0,ret[4]);
    }

    @Test
    void test3() {

        ListNode node = ListNode.fromArray(new int[]{1,7,5,1,9,2,5,1});
        Solution solution = new Solution();
        int[] ret = solution.nextLargerNodes(node);
        assertEquals(7,ret[0]);
        assertEquals(9,ret[1]);
        assertEquals(9,ret[2]);
        assertEquals(9,ret[3]);
        assertEquals(0,ret[4]);
        assertEquals(5,ret[5]);
        assertEquals(0,ret[6]);
        assertEquals(0,ret[7]);
    }

}