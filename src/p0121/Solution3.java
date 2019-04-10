package p0121;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution3 { //brute force with sellAt function

    int countTime = 0;
    HashMap<String,Integer> mem = new HashMap<>();

    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;
        return sellAt(0,prices);
    }

    private int sellAt(int buyPos,int[] prices) {

        int max = 0;
        int currentPrice = prices[buyPos];
        StringBuilder sb;
        for(int i = buyPos+1;i<prices.length;i++) {

            int different;
            sb = new StringBuilder();
            sb.append(prices[i]).append("-").append(currentPrice);
            String key = sb.toString();
            if (mem.containsKey(key))
                different = mem.get(key);
            else {
                different = prices[i] - currentPrice;
                if (different>0)
                mem.put(key,different);
                countTime++;

            }
//            System.out.print(prices[i]);
//            System.out.print("-");
//            System.out.println(currentPrice);

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

        Solution3 solution = new Solution3();
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
