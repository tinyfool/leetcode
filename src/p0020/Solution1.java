package p0020;

//Runtime: 1 ms, faster than 98.28% of Java online submissions for Valid Parentheses.
//        Memory Usage: 34.5 MB, less than 99.92% of Java online submissions for Valid Parentheses.

public class Solution1 {

    int top = -1;
    char[] stack;
    public boolean isValid(String s) {

        stack = new char[s.length()];
        for(char c:s.toCharArray()) {

            if(c=='('||c=='{'||c=='[')
                push(c);
            if(c==')'||c=='}'||c==']') {

                try {
                    char c1 = pop();
                    if(!match(c1,c))
                        return false;
                }catch (Exception e){
                    return false;
                }
            }
        }
        if(top>=0)
            return false;
        return true;
    }

    private void push(char c) {
        top++;
        stack[top] = c;
    }

    private char pop() throws Exception {
        if(top<0)
            throw new Exception("underflow");
        char c = stack[top];
        top--;
        return c;
    }

    private boolean match(char left,char right) {

        if (left=='[' && right==']')
            return true;
        if (left=='(' && right==')')
            return true;
        if (left=='{' && right=='}')
            return true;
        return false;
    }

    public static void main(String[] args){

        String s = "()";
        Solution1 s1 = new Solution1();
        System.out.println(s1.isValid(s));
    }
}
