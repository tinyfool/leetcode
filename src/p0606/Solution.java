package p0606;

import helper.TreeNode;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-07 13:42
 */

//Runtime: 6 ms, faster than 77.90% of Java online submissions for Construct String from Binary Tree.
//Memory Usage: 40.4 MB, less than 28.57% of Java online submissions for Construct String from Binary Tree.
    
public class Solution {

    public String tree2str(TreeNode t) {

        return node2Str(t);
    }

    String node2Str(TreeNode root) {

        if (root == null)
            return "";
        String l = node2Str(root.left);
        String r = node2Str(root.right);
        if (l.equals("") && r.equals(""))
            return String.valueOf(root.val);
        if (r.equals(""))
            return root.val + "(" + l + ")";
        else
            return root.val + "(" + l + ")" + "(" + r + ")";
    }
}
