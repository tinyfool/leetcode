package p0230;

import helper.TreeNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
//Memory Usage: 38.1 MB, less than 96.22% of Java online submissions for Kth Smallest Element in a BST.

public class Solution {
    int i =0;
    Integer ret = null;
    public int kthSmallest(TreeNode root,int k) {

        inOrder(root,k);
        return ret;
    }

    private void inOrder(TreeNode root,int k){

        if(ret!=null)
            return;
        if(root==null)
            return;
        inOrder(root.left,k);
        i++;
        if(i==k){
            ret = root.val;
            return;
        }
        inOrder(root.right,k);
    }
}
