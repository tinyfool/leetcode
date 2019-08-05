package p0103;

import helper.TreeNode;

import java.util.*;

//Runtime: 1 ms, faster than 92.61% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
//Memory Usage: 36 MB, less than 99.80% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

public class Solution {

    Queue<TreeNode> queue = new LinkedList<>();

    int level = 0;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;

        queue.add(root);
        int n = 0;
        while (!queue.isEmpty()) {

            n++;
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
            if(n%2==0)
                Collections.reverse(leverList);
            list.add(leverList);
        }
        return list;
    }
}
