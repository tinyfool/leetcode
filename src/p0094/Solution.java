package p0094;

import helper.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
//Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.

public class Solution {

    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {

        list = new ArrayList<>();
        inorder(root);
        return list;
    }

    private void inorder(TreeNode node) {

        if(node==null)
            return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

}
