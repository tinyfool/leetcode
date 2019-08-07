package p0450;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    //    5
    //   / \
    //  3   6
    // / \   \
    //2   4   7


    Solution solution =new Solution();

    @Test
    void test1() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right =new TreeNode(4);
        root.right.right=new TreeNode(7);

        TreeNode excepted = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.right.right=new TreeNode(7);

        assertTrue(TreeNode.sameTree(excepted,solution.deleteNode(root,3)));
    }
}