package p0107;

import helper.TreeNode;

import java.util.*;

//Runtime: 1 ms, faster than 97.90% of Java online submissions for Binary Tree Level Order Traversal II.
//Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.

public class Solution {

    Queue<TreeNode> queue = new LinkedList<>();

    int level = 0;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;

        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> leverList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                leverList.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            list.add(leverList);
        }
        Collections.reverse(list);
        return list;
    }
}
