package p0515;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Runtime: 2 ms, faster than 73.72% of Java online submissions for Find Largest Value in Each Tree Row.
//Memory Usage: 38.4 MB, less than 94.83% of Java online submissions for Find Largest Value in Each Tree Row.

public class Solution {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int size = queue.size();
            Integer max = null;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(max==null || max<curr.val)
                    max = curr.val;
                if(curr.left!=null)
                   queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            list.add(max);
        }
        return list;
    }

}
