package p0222;

import helper.TreeNode;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
//Memory Usage: 39.5 MB, less than 68.64% of Java online submissions for Count Complete Tree Nodes.

public class Solution {

    public int countNodes(TreeNode root) {

        if(root==null)
            return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
