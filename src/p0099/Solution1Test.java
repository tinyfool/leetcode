package p0099;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    Solution1 solution1 = new Solution1();

    @Test
    void test1(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);

        solution1.recoverTree(root);

        TreeNode exceptRoot = new TreeNode(3);
        exceptRoot.left = new TreeNode(1);
        exceptRoot.left.left = new TreeNode(2);
        assertTrue(TreeNode.sameTree(root,exceptRoot));
    }

    @Test
    void test2(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        TreeNode exceptRoot = new TreeNode(2);
        exceptRoot.left = new TreeNode(1);
        exceptRoot.right = new TreeNode(4);
        exceptRoot.right.left = new TreeNode(3);
        solution1.recoverTree(root);
        assertTrue(TreeNode.sameTree(root,exceptRoot));
    }
}