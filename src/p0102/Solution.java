package p0102;
import helper.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Runtime: 1 ms, faster than 88.01% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
public class Solution {

    Queue<TreeNode> queue = new LinkedList<>();

    int level = 0;

    public List<List<Integer>> levelOrder(TreeNode root) {

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
        return list;
    }
}
