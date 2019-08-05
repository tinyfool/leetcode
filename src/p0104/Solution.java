package p0104;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Runtime: 1 ms, faster than 11.74% of Java online submissions for Maximum Depth of Binary Tree.
//Memory Usage: 39 MB, less than 96.53% of Java online submissions for Maximum Depth of Binary Tree.

public class Solution {

    Queue<TreeNode> queue = new LinkedList<>();

    int level = 0;

    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;
        queue.add(root);
        int n = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            n++;
        }
        return n;
    }
}
