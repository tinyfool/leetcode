package p0173;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTIteratorTest {

    @Test
    void test1() {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        assertEquals(3,iterator.next());    // return 3
        assertEquals(7,iterator.next());    // return 7
        assertTrue(iterator.hasNext()); // return true
        assertEquals(9,iterator.next());    // return 9
        assertTrue(iterator.hasNext()); // return true
        assertEquals(15,iterator.next());    // return 15
        assertTrue(iterator.hasNext()); // return true
        assertEquals(20,iterator.next());    // return 20
        assertFalse(iterator.hasNext()); // return false
    }

}