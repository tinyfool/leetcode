package p0114;

import com.sun.source.tree.Tree;
import helper.TreeNode;
import org.junit.jupiter.api.Test;

//Runtime: 1 ms, faster than 52.03% of Java online submissions for Flatten Binary Tree to Linked List.
//Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.

public class Solution {

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode rightest = root.right;
            TreeNode curr = root.right;
            while (curr!=null) {
                rightest = curr;
                curr = curr.right;
            }
            rightest.right = temp;
        }

        flatten(root.right);
    }
}
