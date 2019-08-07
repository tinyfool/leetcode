package p0572;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-07 13:05
 */
class SolutionTest {
//     3
//    / \
//   4   5
//  / \
// 1   2
//Given tree t:
//   4
//  / \
// 1   2

    @Test
    void test1() {

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right=new TreeNode(5);
        s.left.left=new TreeNode(1);
        s.left.right=new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right=new TreeNode(2);
        Solution solution = new Solution();
        assertTrue(solution.isSubtree(s,t));
    }
    @Test
    void test2() {

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        Solution solution = new Solution();
        assertTrue(solution.isSubtree(s,t));
    }

}