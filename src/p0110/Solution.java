package p0110;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public boolean isBalanced(TreeNode root) {

        if(root==null)
            return true;
        int diff = Math.abs(height(root.left)-height(root.right));
        return (diff<=1) && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(TreeNode node) {

        if(node==null)
            return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
