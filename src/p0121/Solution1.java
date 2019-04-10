package p0121;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution1 { //brute force with sellAt function

    int countTime = 0;
    public int maxProfit(int[] prices) {

        int max = 0;
        for(int i = 0;i<prices.length-1;i++) {

            int price = sellAt(i,prices);
            if (price > max)
                max = price;
        }
        return max;
    }

    private int sellAt(int buyPos,int[] prices) {

        int max = 0;
        for (int i = buyPos;i<prices.length;i++) {
            int price = prices[i] - prices[buyPos];
            countTime++;
            if (price>max)
                max = price;
        }
        return max;
    }
    public static void main(String[] args) throws IOException{

        Solution1 solution = new Solution1();
        int[] prices;
        prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.countTime);

        solution.countTime = 0;
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
