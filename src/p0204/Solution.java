package p0204;

import java.util.ArrayList;
//太慢，暂时跳过，回头慢慢学习素数快速求法
class Solution {

    public int countPrimes(int n) {

        if(n<=2)
            return 0;
        if(n<3)
            return 1;

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for(int i=3;i<n;i++) {

            int prime = 1;
            for(int num:primes) {
                if(i%num==0) {
                    prime = 0;
                    break;
                }
            }
            if(prime==1)
                primes.add(i);
        }
        return primes.size();
    }
}