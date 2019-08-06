package p0235;

import helper.TreeNode;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 09:30
 */

//Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
//Memory Usage: 36.8 MB, less than 5.09% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.

public class Solution {

    TreeNode ret;
    int found = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ret = root;
        return lowestCommonAncestorCurr(root,p,q);
    }

    TreeNode lowestCommonAncestorCurr(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if(root == p|| root ==q)
            return root;

        if(p.val<root.val&& q.val<root.val)
            return lowestCommonAncestorCurr(root.left,p,q);
        else if(p.val>root.val&& q.val>root.val)
            return lowestCommonAncestorCurr(root.right,p,q);
        else
            return root;
    }
}
