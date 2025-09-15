package Preparation.Specific.Nasdaq.RealQuestions.Review;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Stock {
    //not tree map here bas
    public static void main(String[] args) {
        String[] stocks = {"AAPL", "MSFT", "GOOG", "AMZN", "TSLA", "META", "NVDA", "NFLX"};
        double[][] prices = {
                {10.0},                              // 1 price
                {8.0, 7.0},                          // 2 prices
                {6.0, 5.0, 4.0},                     // 3 prices
                {3.0, 2.0, 1.0, 2.0},                // 4 prices
                {1.0, 2.0, 3.0, 4.0, 5.0},           // 5 prices
                {2.0, 2.0, 2.0, 2.0, 2.0, 2.0},      // 6 prices
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}, // 7 prices
                {5.0, 4.0, 3.0, 2.0, 1.0, 0.0, 1.0, 2.0} // 8 prices
        };
        System.out.println(helper(stocks,prices));
    }
    public static String [] helper (String [] stocks, double [][] prices) {
        String [] ans = new String[3];
        TreeMap<Double, String> hm = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < stocks.length; i ++) {
            double currentPrice = 0;
            for (int j = 0; j < prices[i].length; j++) {
                currentPrice += prices[i][j];
            }
            double average = currentPrice / prices[i].length;
            hm.putIfAbsent(average, stocks[i]);
        }
        int index = 0;
        for (String stock : hm.values()) {
            if (index == 3) break;
            ans[index++] = stock;
        }
        return ans;
    }
}
