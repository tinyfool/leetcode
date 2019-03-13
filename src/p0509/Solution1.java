package p0509;

public class Solution1 { //navie recursion

    public int fib(int N) {

        int f;
        if ( N==0 )
            return 0;
        if ( N <=2 )
            return  1;
        f = fib(N-1)+fib(N-2);
        return f;
    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        long t1 = System.currentTimeMillis();
        System.out.println(solution1.fib(40));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
