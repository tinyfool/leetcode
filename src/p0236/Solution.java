package p0236;

import helper.TreeNode;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 09:30
 */

//Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
//Memory Usage: 35.3 MB, less than 5.03% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lowestCommonAncestorCurr(root, p, q);
    }

    TreeNode lowestCommonAncestorCurr(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode l = lowestCommonAncestorCurr(root.left, p, q);
        TreeNode r = lowestCommonAncestorCurr(root.right, p, q);
        if (l != null && r != null)
            return root;
        if (l == null && r == null)
            return null;
        return l != null ? l : r;
    }
}
