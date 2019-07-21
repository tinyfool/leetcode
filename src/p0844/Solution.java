package p0844;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Runtime: 5 ms, faster than 5.63% of Java online submissions for Backspace String Compare.
//        Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Backspace String Compare.

public class Solution {

    public boolean backspaceCompare(String S, String T) {

        String s1 = simplify(S);
        String s2 = simplify(T);
        return s1.equals(s2);
    }

    private String simplify(String S) {

        Stack<Character> stack = new Stack<>();
        for (char c:
                S.toCharArray()) {
            if(c=='#') {

                if(!stack.isEmpty())
                    stack.pop();
            }else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {

            sb.append(stack.pop());
        }

        String word = sb.reverse().toString();
        System.out.println(word);
        return word;
    }

    @Test
    public void test() {

        Solution s1 = new Solution();
        assertEquals(true,s1.backspaceCompare("ab#c","ad#c"));
        assertEquals(true,s1.backspaceCompare("ab##","c#d#"));
        assertEquals(true,s1.backspaceCompare("a##c","#a#c"));
        assertEquals(false,s1.backspaceCompare("a#c","b"));
    }
}
