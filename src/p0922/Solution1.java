package p0922;

import java.util.ArrayList;
import java.util.List;

//Runtime: 6 ms, faster than 16.34% of Java online submissions for Sort Array By Parity II.
//        Memory Usage: 41.8 MB, less than 69.86% of Java online submissions for Sort Array By Parity II.

public class Solution1 {

    public int[] sortArrayByParityII(int[] A) {

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int num:A
             ) {
            if(num%2==0) {
                even.add(num);
            }else
                odd.add(num);
        }
        int [] ret = new int[A.length];
        for(int i=0;i<odd.size();i++) {
            ret[i*2] = even.get(i);
            ret[i*2+1] = odd.get(i);
        }
        return ret;
    }
}
