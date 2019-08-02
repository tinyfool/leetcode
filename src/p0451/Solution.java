package p0451;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//Runtime: 5 ms, faster than 95.32% of Java online submissions for Sort Characters By Frequency.
//Memory Usage: 38.6 MB, less than 87.60% of Java online submissions for Sort Characters By Frequency.

public class Solution {

    public String frequencySort(String s) {

        int[][] counts = new int[256][2];
        for (char c:s.toCharArray()
             ) {
            counts[c][0] = c;
            counts[c][1]++;
        }
        Arrays.sort(counts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char i=255;i>=0;i--) {

            if(counts[i][1]==0)
                break;
            for(int j=0;j<counts[i][1];j++) {
                char c = (char)counts[i][0];
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
