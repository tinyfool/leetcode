package p0110;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Runtime: 1 ms, faster than 94.52% of Java online submissions for Balanced Binary Tree.
//Memory Usage: 39.4 MB, less than 26.10% of Java online submissions for Balanced Binary Tree.

class Solution1Test {

    Solution1 solution = new Solution1();

    @Test
    void test1() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    void test2() {

        assertTrue( solution.isBalanced(null));
    }

    @Test
    void test3() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        assertFalse(solution.isBalanced(root));
    }

    @Test
    void test4() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        assertFalse(solution.isBalanced(root));
    }
}