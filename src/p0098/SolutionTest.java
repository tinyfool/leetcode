package p0098;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    void test4() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    void test5() {

        TreeNode node = new TreeNode(2147483647);
        assertTrue(solution.isValidBST(node));
    }
//[-2147483648,null,2147483647]

    @Test
    void test6() {

        TreeNode node = new TreeNode(-2147483648);
        node.right = new TreeNode(2147483647);
        assertTrue(solution.isValidBST(node));
    }

}