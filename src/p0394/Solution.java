package p0394;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

//暂时跳过

public class Solution {

    Stack<Character> numStack = new Stack<>();
    Stack<String> stack = new Stack<>();

    public String decodeString(String s) {

        int inNum = 0;
        for (char c:s.toCharArray()) {

            if(Character.isDigit(c)) {
                inNum = 1;
                numStack.push(c);
            } else {

                if(inNum==1) {

                    inNum = 0;
                    String num = getNumber();
                    stack.push(num);
                }
                if (c == ']'){

                    repeat();
                }
                else
                    stack.push(String.valueOf(c));
            }
        }

        StringBuilder retSb = new StringBuilder();
        for (String word:stack
             ) {
            retSb.append(word);
        }
        return retSb.toString();
    }

    private String getNumber() {

        StringBuilder sb = new StringBuilder();
        while (!numStack.isEmpty()) {
            sb.append(numStack.pop());
        }
        return sb.reverse().toString();
    }

    private void repeat() {

        StringBuilder sb = new StringBuilder();
        StringBuilder wordSb = new StringBuilder();
        while (!stack.isEmpty()){
            String w = stack.pop();
            if(w.equals("[")) {

                String time = stack.pop();
                int timeNum = Integer.parseInt(time);
                String word = wordSb.reverse().toString();
                for(int i = 0;i<timeNum;i++) {
                    sb.append(word);
                }
                stack.push(sb.toString());
                break;
            }else {

                wordSb.append(w);
            }
        }
    }
    @Test
    public void testCase() {

        Solution s1 = new Solution();
        //assertEquals("aaabcbc",s1.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc",s1.decodeString("3[a2[c]"));
        assertEquals("abcabccdcdcdef",s1.decodeString("2[abc]3[cd]ef"));
    }
}
