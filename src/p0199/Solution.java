package p0199;

import helper.TreeNode;

import java.util.*;

//Runtime: 1 ms, faster than 97.78% of Java online submissions for Binary Tree Right Side View.
//Memory Usage: 35.2 MB, less than 99.67% of Java online submissions for Binary Tree Right Side View.

public class Solution {

    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root){

        list = new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int size = queue.size();
            TreeNode curr = null;
            for(int i=0;i<size;i++) {
                curr = queue.poll();
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            list.add(curr.val);
        }
        return list;
    }
}
