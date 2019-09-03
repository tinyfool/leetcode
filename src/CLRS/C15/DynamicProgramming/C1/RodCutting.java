package CLRS.C15.DynamicProgramming.C1;

import java.util.HashMap;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-30 17:27
 */
public class RodCutting {

    public int count = 0;
    HashMap<Integer, Integer> resultMap = new HashMap<>();

    public int cutRod(int[] prices, int n) {

        count++;
        if (n == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int other = cutRod(prices, n - i - 1);
            if (other + prices[i] > max)
                max = prices[i] + other;
        }
        return max;
    }


    public int cutRodHash(int[] prices, int n) {

        count++;
        if (n == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int other;
            int otherIndex = n - i - 1;
            if (resultMap.containsKey(otherIndex)) {
                other = resultMap.get(otherIndex);
            } else {
                other = cutRodHash(prices, otherIndex);
                resultMap.put(otherIndex, other);
            }
            if (other + prices[i] > max)
                max = prices[i] + other;
        }
        return max;
    }

    public int cutRodBottomUp(int[] prices, int n) {
        count++;
        int[] r = new int[n+1];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j <=i; j++) {

                if(prices[j]+r[i-j]>max) {
                    max = prices[j]+r[i-j];
                }
            }
            r[i+1]= max;
        }
        return r[n];
    }
}

