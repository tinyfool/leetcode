package p0509;

import java.util.HashMap;

public class Solution2 { //Hashmap DP

    HashMap<Integer,Integer> mem = new HashMap<>();
    public int fib(int N) {

        int f;
        if (mem.containsKey(N))
            return mem.get(N);

//        System.out.print("N=");
//        System.out.println(N);

        if ( N==0 ) {
            f = 0;
        }else if ( N <=2 ) {
            f = 1;
        }else {
            f = fib(N-1)+fib(N-2);
        }
        mem.put(N,f);
        return f;
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        long t1 = System.nanoTime();
        System.out.println(solution2.fib(40));
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }
}
