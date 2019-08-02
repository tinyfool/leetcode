package p0876;

import org.junit.jupiter.api.Test;
import helper.ListNode;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5});
        Solution solution = new Solution();
        node = solution.middleNode(node);
        assertEquals(3,node.val);
    }

    @Test
    void test2() {

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5,6});
        Solution solution = new Solution();
        node = solution.middleNode(node);
        assertEquals(4,node.val);
    }

}