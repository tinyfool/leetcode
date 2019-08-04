package p0099;

import helper.TreeNode;

//Runtime: 2 ms, faster than 97.93% of Java online submissions for Recover Binary Search Tree.
//Memory Usage: 39 MB, less than 78.01% of Java online submissions for Recover Binary Search Tree.

class Solution1 {

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);
        System.out.println(node.val);
        if(prev!=null && prev.val>=node.val) {
            if(first==null) {
                first = prev;
                second = node;
            }
            else
                second = node;
        }
        prev = node;
        inorder(node.right);
    }
}