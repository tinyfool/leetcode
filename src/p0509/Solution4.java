package p0509;

import p0567.Solution1;

import java.util.HashMap;

public class Solution4 { //DP tabulation with hashmap

    int[] mem = new int[50];

    Solution4() {

        for(int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
    }

    public int fib(int N) {

        if (mem[N]!=-1)
            return mem[N];

        //System.out.print("N=");
        //System.out.println(N);

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
        mem[N] =f;
        return f;
    }

    public static void main(String[] args) {

        Solution4 solution4 = new Solution4();
        long t1 = System.nanoTime();
        System.out.println(solution4.fib(40));
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }
}
