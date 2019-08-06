package p0257;

import helper.TreeNode;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-06 11:47
 */

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();
        path(list,null,root);
        return list;
    }

    void path(List<String> list,String parent,TreeNode root){
        if (root==null)
            return;
        String path;
        if(parent==null)
            path = ""+root.val;
        else
            path = parent+"->"+root.val;
        if(root.left== null && root.right==null) {
            list.add(path);
            return;
        }
        path(list,path,root.left);
        path(list,path,root.right);
    }
}
