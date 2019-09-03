package p0005;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution4 {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        String res = null;

        boolean[][] dp = new boolean[n][n];
        int longi = 0;
        int longj = 0;
        int length = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (j - i + 1 > length)) {
                    longi = i;
                    longj = j;
                    length = j-i+1;
                }
            }
        }
        res = s.substring(longi, longj + 1);
        return res;
    }
}
