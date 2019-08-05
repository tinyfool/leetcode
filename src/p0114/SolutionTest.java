package p0114;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();
    @Test
    void test1() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode excepted = new TreeNode(1);
        excepted.right = new TreeNode(2);
        excepted.right.right = new TreeNode(3);
        excepted.right.right.right = new TreeNode(4);
        excepted.right.right.right.right = new TreeNode(5);
        excepted.right.right.right.right.right = new TreeNode(6);

        solution.flatten(root);
        assertTrue(TreeNode.sameTree(excepted,root));
    }
}