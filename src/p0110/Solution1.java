package p0110;

import helper.TreeNode;

//Runtime: 1 ms, faster than 94.52% of Java online submissions for Balanced Binary Tree.
//Memory Usage: 40.9 MB, less than 26.10% of Java online submissions for Balanced Binary Tree.

public class Solution1 {


    public boolean isBalanced(TreeNode root) {

        if(root==null)
            return true;
        int hl = height(root.left);
        if(hl==-1)
            return false;
        int hr = height(root.right);
        if(hr==-1)
            return false;
        int diff = Math.abs(hl-hr);

        return diff<=1;
    }

    int height(TreeNode node) {

        if(node==null)
            return 0;
        int hl = height(node.left);
        if(hl==-1)
            return -1;
        int hr = height(node.right);
        if(hr==-1)
            return -1;
        if(Math.abs(hl-hr)>1)
            return -1;
        return Math.max(hl,hr)+1;
    }
}
