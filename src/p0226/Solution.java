package p0226;

import helper.TreeNode;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
//Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Invert Binary Tree.

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null)
            invertTree(root.left);
        if(root.right!=null)
            invertTree(root.right);
        return root;
    }


}