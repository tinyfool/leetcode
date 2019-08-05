package p0111;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @Test
    void test1(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(2,solution.minDepth(root));
    }

    @Test
    void test2(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        assertEquals(2,solution.minDepth(root));
    }


}