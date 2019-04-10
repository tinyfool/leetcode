package p0121;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution4 { //one pass


    public int maxProfit(int[] prices) {

        int minPrice = -1;
        int maxProfitValue = 0;

        for(int i = 0;i<prices.length;i++) {
            if (minPrice==-1)
                minPrice = prices[i];
            else if(minPrice>prices[i] && i!=prices.length-1) {
                minPrice = prices[i];
            }
            int currentProfit = prices[i] - minPrice;
            if (currentProfit>maxProfitValue)
                maxProfitValue = currentProfit;
        }
        return maxProfitValue;
    }

    public static void main(String[] args) throws IOException {

        Solution4 solution = new Solution4();
        int[] prices;
        prices = new int[]{7,1,5,3,2,3,1,1,2,6,4};
        System.out.println(solution.maxProfit(prices));

        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));

        String file = "data/p0121/test1";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        String[] parts = s.split(",");
        int[] numbers = new int[parts.length];
        for(int i = 0;i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(solution.maxProfit(numbers));
    }
}
