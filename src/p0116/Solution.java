package p0116;

import helper.TNode.Node;

import java.util.LinkedList;
import java.util.Queue;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
//Memory Usage: 34.6 MB, less than 98.71% of Java online submissions for Populating Next Right Pointers in Each Node.
public class Solution {

    public Node connect(Node root) {

        if(root==null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            Node prev = null;
            for (int i=0;i<size;i++) {

                Node curr = queue.poll();
                if (prev!=null)
                    prev.next = curr;
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                prev = curr;
            }
        }
        return root;
    }
}
