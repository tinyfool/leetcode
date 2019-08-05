package p0199;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeCellRenderer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        assertEquals(list,solution.rightSideView(root));
    }
}