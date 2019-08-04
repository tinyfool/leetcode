package p0100;

import helper.TreeNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
//Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Same Tree.
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}