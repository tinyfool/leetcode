package p0101;


import helper.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return symmetric(root.left,root.right);
    }

    private boolean symmetric(TreeNode left,TreeNode right) {

        if(left==null && right==null)
            return true;
        if(left==null || right==null ||left.val!=right.val)
            return false;

        return symmetric(left.left,right.right) && symmetric(left.right,right.left);
    }
}