package p0145;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
//Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Binary Tree Postorder Traversal.

public class Solution {

    List<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root){

        list = new ArrayList<>();
        postorder(root);
        return list;
    }

    void postorder(TreeNode root) {

        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
}
