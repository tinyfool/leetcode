package p0173;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Runtime: 56 ms, faster than 99.38% of Java online submissions for Binary Search Tree Iterator.
//Memory Usage: 50.7 MB, less than 93.40% of Java online submissions for Binary Search Tree Iterator.
public class BSTIterator {

    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {

        queue = new LinkedList<>();
        inorder(root);
    }

    void inorder(TreeNode root) {

        if(root == null)
            return;
        inorder(root.left);
        queue.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext(){

        return !queue.isEmpty();
    }
}
