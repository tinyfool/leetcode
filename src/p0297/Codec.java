package p0297;


import helper.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 12:36
 */

//Runtime: 11 ms, faster than 72.04% of Java online submissions for Serialize and Deserialize Binary Tree.
//Memory Usage: 39.4 MB, less than 68.91% of Java online submissions for Serialize and Deserialize Binary Tree.
    
public class Codec {

    public String serialize(TreeNode root){

        if(root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeCurr(sb,root);
        return sb.toString();
    }

    void serializeCurr(StringBuilder sb, TreeNode root){

        if (root==null) {
            sb.append(",");
            sb.append("#");
            return;
        }
        if(sb.length()!=0)
            sb.append(",");
        sb.append(root.val);
        serializeCurr(sb,root.left);
        serializeCurr(sb,root.right);
    }

    public TreeNode deserialize(String data) {

        if(data==null||data.length()==0)
            return null;
        String[] strs = data.split(",");
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(strs));
        return deserializeCurr(nodes);
    }

    TreeNode deserializeCurr(Queue<String> nodes) {

        if(nodes.isEmpty())
            return null;
        String val = nodes.poll();
        if(val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserializeCurr(nodes);
        root.right = deserializeCurr(nodes);
        return root;
    }
}
