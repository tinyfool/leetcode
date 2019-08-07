package p0404;

import helper.TreeNode;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeavesCurr(root);
    }

    int sumOfLeftLeavesCurr(TreeNode root){

        if(root==null)
            return 0;
        int n = 0;
        if(root.left!=null && root.left.left==null&& root.left.right==null) {
            n = root.left.val;
        }
        return n+sumOfLeftLeavesCurr(root.left)+sumOfLeftLeavesCurr(root.right);
    }
}
