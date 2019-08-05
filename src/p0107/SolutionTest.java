package p0107;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(7);
        expected.add(list);
        list = new ArrayList<>();
        list.add(9);
        list.add(20);
        expected.add(list);
        list = new ArrayList<>();
        list.add(3);
        expected.add(list);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(expected, solution.levelOrderBottom(root));
    }

    @Test
    void test2() {

        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, solution.levelOrderBottom(null));
    }

}