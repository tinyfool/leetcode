package p0144;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
//Memory Usage: 34.9 MB, less than 99.80% of Java online submissions for Binary Tree Preorder Traversal.

public class Solution {

    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root){

        list = new ArrayList<>();
        preorder(root);
        return list;
    }

    void preorder(TreeNode root) {

        if(root==null)
            return;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
