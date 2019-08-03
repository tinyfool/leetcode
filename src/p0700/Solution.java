package p0700;

import helper.TreeNode;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
//Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Search in a Binary Search Tree.

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
