package p0226;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution226Test {

    @Test
    void test1() {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode excepted = new TreeNode(4);
        excepted.left = new TreeNode(7);
        excepted.right = new TreeNode(2);
        excepted.left.left = new TreeNode(9);
        excepted.left.right = new TreeNode(6);
        excepted.right.left = new TreeNode(3);
        excepted.right.right = new TreeNode(1);

        assertTrue(TreeNode.sameTree(excepted,solution.invertTree(root)));
    }

}