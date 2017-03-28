import java.util.Scanner;
import java.util.Stack;

/**
 * Created by haopeiqiang on 2017/3/28.
 */
public class Solution476 {
    public int findComplement(int num) {

        int mask = (1 << this.count(num)) -1;
        return mask ^ num;
    }

    public int count(int num) {

        int n = 0;
        while(num>0) {

            num = num >> 1;
            n++;
        }
        return n;
    }
    public void d2b(int num) {

        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        while (num != 0)
        {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }

        System.out.print("\nBinary representation is:");

        while (!(stack.isEmpty() ))
        {
            System.out.print(stack.pop());
        }

        System.out.println();
    }
    public static void main(String[] argv) {

        Solution476 solution = new Solution476();
        System.out.println(solution.findComplement(5));
    }
}



