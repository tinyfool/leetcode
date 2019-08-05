package p0111;

import helper.TreeNode;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
//Memory Usage: 39 MB, less than 97.86% of Java online submissions for Minimum Depth of Binary Tree.

public class Solution {

    public int minDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        if(root.left==null)
            return minDepth(root.right)+1;
        if(root.right==null)
            return minDepth(root.left)+1;

        int mL = minDepth(root.left);
        int mR = minDepth(root.right);
        return Math.min(mL,mR)+1;
    }
}
