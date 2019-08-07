package p0572;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-07 12:59
 */

//user #100 same tree
//Runtime: 6 ms, faster than 89.06% of Java online submissions for Subtree of Another Tree.
//Memory Usage: 41 MB, less than 86.21% of Java online submissions for Subtree of Another Tree.

class Solution {

    List<TreeNode> list;
    public boolean isSubtree(TreeNode s, TreeNode t) {

        list = new ArrayList<>();
        if(s==null&&t==null)
            return true;
        if(t==null)
            return true;
        seachInTree(s,t.val);
        for (TreeNode node:list) {

            if (isSameTree(node,t))
                return true;
        }
        return false;
    }

    void seachInTree(TreeNode root,int val){

        if(root==null)
            return;
        if(root.val==val) {
            list.add(root);
        }
        seachInTree(root.left,val);
        seachInTree(root.right,val);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}