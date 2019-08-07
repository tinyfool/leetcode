package p0515;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //
    //Output: [1, 3, 9]

    @Test
    void test1() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(9);
        Solution solution = new Solution();
        assertEquals(list, solution.largestValues(root));
    }

    @Test
    void test2() {

        List<Integer> list = new ArrayList<>();
        Solution solution = new Solution();
        assertEquals(list, solution.largestValues(null));
    }

}