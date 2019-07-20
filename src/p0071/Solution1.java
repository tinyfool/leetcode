package p0071;

import java.util.Stack;
//Runtime: 6 ms, faster than 40.84% of Java online submissions for Simplify Path.
//        Memory Usage: 36.6 MB, less than 99.87% of Java online submissions for Simplify Path.

public class Solution1 {

    public String simplifyPath(String path) {

        Stack<String> pathStack = new Stack<>();
        String[] pathArray = path.split("/");
        for(String c:pathArray) {
            if(c.equals("") || c.equals(".")) {

            }else if(c.equals("..")) {
                if(pathStack.size()>0)
                    pathStack.pop();
            }else {

                pathStack.push(c);
            }
        }
        if (pathStack.size()==0)
            return "/";
        String[] paths = new String[pathStack.size()];
        int i = 0;
        for (String c:pathStack
             ) {
            paths[i] = c;
            i++;
        }
        return "/"+String.join("/",paths);
    }

    public static void main(String[] args) {

        String path ="/a/../../b/../c//.//";
        path = "/a//b////c/d//././/..";
        Solution1 s1 = new Solution1();
        System.out.println(s1.simplifyPath(path));
    }
}
