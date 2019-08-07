package p0606;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeCellRenderer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-07 13:42
 */
class SolutionTest {

//       1
//     /   \
//    2     3
//   /
//  4

//Output: "1(2(4))(3)"

    @Test
    void test1(){

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        Solution solution=new Solution();
        assertEquals("1(2(4))(3)",solution.tree2str(root));
    }

//       1
//     /   \
//    2     3
//     \
//      4
//
//Output: "1(2()(4))(3)"

    @Test
    void test2(){

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        Solution solution=new Solution();
        assertEquals("1(2()(4))(3)",solution.tree2str(root));
    }

}