package p0274;

import java.util.Arrays;
import java.util.Collections;
//暂时跳过
public class Solution1 {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        for (int i=citations.length-1;i>0;i--) {
            int no = citations.length-i;
            if (no>citations[i])
                return no-1;
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] citations = new int[]{3,0,6,1,5};
        Solution1 s1 = new Solution1();
        System.out.println(s1.hIndex(citations));

        citations = new int[]{0,1};
        System.out.println(s1.hIndex(citations));
    }
}
