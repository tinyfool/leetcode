package p0094;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution solution = new Solution();


    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        assertEquals(list,solution.inorderTraversal(root));
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(list,solution.inorderTraversal(root));
    }
}