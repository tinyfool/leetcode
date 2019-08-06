package p0257;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 12:04
 */
class SolutionTest {

    @Test
    void test1(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right =new TreeNode(5);
        List<String > excepted =new ArrayList<>();
        excepted.add("1->3");
        excepted.add("1->2->5");
        Solution solution = new Solution();
        List actual = solution.binaryTreePaths(root);
        Collections.sort(excepted);
        Collections.sort(actual);
        assertEquals(excepted,actual);
    }
}