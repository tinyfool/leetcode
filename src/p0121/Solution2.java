package p0121;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution2 { //brute force with sellAt function

    int countTime = 0;
    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;
        return sellAt(0,prices);
    }

    private int sellAt(int buyPos,int[] prices) {

        int max = 0;
        int currentPrice = prices[buyPos];
        for(int i = buyPos+1;i<prices.length;i++) {

            int different = prices[i]-currentPrice;
//            System.out.print(prices[i]);
//            System.out.print("-");
//            System.out.println(currentPrice);
            countTime++;
            if(different>max)
                max = different;
        }
        if(buyPos<prices.length-1) {
            int startNext = sellAt(buyPos + 1, prices);
            if (startNext > max)
                max = startNext;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        Solution2 solution = new Solution2();
        int[] prices;
        prices = new int[]{7,1,5,3,2,3,1,1,2,6,4};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.countTime);

        solution.countTime=0;
        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.countTime);

        String file = "data/p0121/test1";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        String[] parts = s.split(",");
        int[] numbers = new int[parts.length];
        for(int i = 0;i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        solution.countTime = 0;
        System.out.println(solution.maxProfit(numbers));
        System.out.println(solution.countTime);
    }
}
