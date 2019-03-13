package p0509;

import java.util.HashMap;

public class Solution3 { //DP tabulation with hashmap

    HashMap<Integer,Integer> mem = new HashMap<>();

    public int fib(int N) {

        if (mem.containsKey(N))
            return mem.get(N);

//        System.out.print("N=");
//        System.out.println(N);

        int f=0;
        if ( N==0 ) {
            f = 0;
        }else if ( N <=2 ) {
            f = 1;
        }else {

            for (int i = 3; i <= N; i++) {
                f = fib(i-1)+fib(i-2);
            }
        }
        mem.put(N,f);
        return f;
    }

    public static void main(String[] args) {

        Solution3 solution3 = new Solution3();
        long t1 = System.nanoTime();
        System.out.println(solution3.fib(40));
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }
}
