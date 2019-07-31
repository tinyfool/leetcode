package p0862;

import java.util.LinkedList;
//暂时跳过
class Solution {

    public int shortestSubarray(int[] A, int K) {

        LinkedList<Integer> queue = new LinkedList<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num:A) {

            queue.add(num);
            sum+=num;

            while (sum>=K) {

                if (queue.size()<min)
                    min = queue.size();
                int f  = queue.removeFirst();
                sum-=f;
            }
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
    }
}