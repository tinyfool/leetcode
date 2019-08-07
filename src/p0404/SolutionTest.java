package p0404;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    @Test
    void test1 () {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(24,solution.sumOfLeftLeaves(root));
    }
}