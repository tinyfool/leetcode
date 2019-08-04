package p0098;

import helper.TreeNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
//Memory Usage: 39.4 MB, less than 75.67% of Java online submissions for Validate Binary Search Tree.
public class Solution {

    public boolean isValidBST(TreeNode root) {

        return isBST(root,null,null);
    }

    private boolean isBST(TreeNode node,Integer min,Integer max) {

        if (node==null)
            return true;

        if(min!=null && node.val<=min)
            return false;
        if(max!=null && node.val>=max)
            return false;

        return isBST(node.left,min,node.val) &&
                isBST(node.right,node.val,max);
    }
}
