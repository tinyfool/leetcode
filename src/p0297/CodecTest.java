package p0297;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 13:17
 */
class CodecTest {

    Codec solution = new Codec();

    @Test
    void test1() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String ret = solution.serialize(root);
        assertEquals("1,2,#,#,3,4,#,#,5,#,#",ret);
        TreeNode retNode = solution.deserialize(ret);
        assertTrue(TreeNode.sameTree(root,retNode));
    }
    @Test
    void test2() {

        String ret = solution.serialize(null);
        assertEquals("",ret);
        TreeNode retNode = solution.deserialize(ret);
        assertTrue(TreeNode.sameTree(null,retNode));
    }
}