package p0449;

import helper.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//lazy solution, just copy 297's solution
//Runtime: 7 ms, faster than 70.86% of Java online submissions for Serialize and Deserialize BST.
//Memory Usage: 39.9 MB, less than 57.28% of Java online submissions for Serialize and Deserialize BST.

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