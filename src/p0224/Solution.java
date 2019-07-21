package p0224;

import java.util.ArrayList;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//暂时跳过

public class Solution {

    Stack<String> stack = new Stack<>();
    Stack<Character> numStack = new Stack<>();

    public int calculate(String s) {

        s = "("+s+")";
        int sum = 0;
        int inNum = 0;
        for (char c:s.toCharArray()) {

            if(!Character.isDigit(c)&&inNum==1) {

                inNum = 0;
                String num = charToNumber();
                stack.push(num);
            }

            if (Character.isDigit(c)||c=='-') {

                inNum = 1;
                numStack.push(c);
            }

            if(c == '(')
                stack.push("(");
            else if(c == '+' || c == '-') {
                stack.push("+");
            } else if(c == ')') {

                StringBuilder sb = new StringBuilder();
                String item = stack.pop();
                int temp = Integer.parseInt(item);
                sb.append(item);
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(temp));
                    break;
                }
                while(!stack.isEmpty()) {

                    item = stack.pop();

                    if(item.equals("(")) {

                        stack.push(String.valueOf(temp));
                        break;
                    }
                    if(item.equals("+")) {

                        sb.append(item);
                        item = stack.pop();
                        sb.append(item);

                        int n2 = Integer.parseInt(item);
                        temp = n2+temp;
                        continue;
                    }
                    if(item.equals("-")) {

                        sb.append(item);
                        item = stack.pop();
                        sb.append(item);
                        if(item.equals("+")) {
                            item = stack.pop();
                            sb.append(item);
                        }
                        int n2 = Integer.parseInt(item);
                        temp = n2-temp;
                    }
                }
                System.out.println(sb.toString());
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private String charToNumber() {

        StringBuilder sb = new StringBuilder();
        while (!numStack.isEmpty()) {
            sb.append(numStack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    public void testCases() {

        Solution s1 = new Solution();

        assertEquals(23, s1.calculate("(1+(4+5+2)-3)+(6+8)"), "(1+(4+5+2)-3)+(6+8) must be 23");
        assertEquals(2147483647, s1.calculate("2147483647"), "2147483647 must be 2147483647");
        assertEquals(3, s1.calculate(" 2-1 + 2 ")," 2-1 + 2  must be 3");
        assertEquals(-4, s1.calculate("1-(5)"),"1-(5) must be -4");
    }

    public static void main(String[] args) {

        String s;
        Solution s1 = new Solution();

        s = "(7)-(0)+(4)";
        System.out.println(s1.calculate(s));
    }
}
