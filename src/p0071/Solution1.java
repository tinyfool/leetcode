package p0071;

import java.util.Stack;
//Runtime: 4 ms, faster than 89.36% of Java online submissions for Simplify Path.
//        Memory Usage: 36 MB, less than 99.87% of Java online submissions for Simplify Path.
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
        StringBuilder sb = new StringBuilder();
        for (String c:pathStack
             ) {
            sb.append("/").append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String path ="/a/../../b/../c//.//";
        path = "/a//b////c/d//././/..";
        Solution1 s1 = new Solution1();
        System.out.println(s1.simplifyPath(path));
    }
}
