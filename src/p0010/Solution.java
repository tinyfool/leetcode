package p0010;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-09-02 13:43
 */
public class Solution {

    public boolean isMatch(String s, String p) {

        int state = 0;
        int n = p.length();
        int[][] transfer = new int[256][n];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < n; j++) {
                transfer[i][j] = -1;
            }
        }
        int i = 0;
        while (i<n) {
            char c = p.charAt(i);
            if(i<n-1 && p.charAt(i+1)=='*'){
                transfer[c][state] = state;
                i+=2;
            }else {
                transfer[c][state] = ++state;
                i++;
            }
        }

        int accept = state;

        Set<Integer> states = new HashSet<>();
        states.add(0);
        for (char c : s.toCharArray()) {
            Set<Integer> tmp = new HashSet<>();
            for (Integer at : states) {
                if(at>=n) continue;
                tmp.add(transfer[c][at]);
                tmp.add(transfer['.'][at]);
            }
            if (tmp.contains(-1)) {
                tmp.remove(-1);
            }
            states = tmp;
        }
        return states.contains(state);
    }

}
