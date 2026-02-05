package CodingQuestions.Algorithms.Important.RealQuestions;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetTopStock {
    /***
     Implement the method getTopStocks(stocks, prices)
     An array Of Strings(Stocks)
     "AMZN", "CACC", "EQIX", "GOOG", "ORLY", "ULTA"
     [12,81, 11.09, 12.11, 10.93, 9.83, 8.14], [10.34, 10.56, 10.14, 12.17]
     */
    public static void main(String[] args) {
        GetTopStock gts = new GetTopStock();
        String[] stocks = {"AMZN", "CACC", "EQIX", "GOOG", "ORLY", "ULTA"};
        double[][] prices = {
                {12.81, 11.09, 12.11},
                {10.93, 9.83, 8.14},
                {10.34, 10.56, 10.14},
                {12.17, 11.99, 12.01},
                {9.99, 10.01, 10.00},
                {8.99, 9.01, 9.00}
        };
        String[] result = gts.getTopStock(stocks, prices);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public String [] getTopStock (String[] stocks, double [][] prices) {
        Map<String, Double> hm = new HashMap();
        for (int i = 0; i < stocks.length; i++) {
            double sum = 0;
            for (double price : prices[i]) {
                sum += price;
            }
            double average = sum / prices[i].length;
            hm.put(stocks[i], average);
        }
        List<Map.Entry<String, Double>> sortedStock = new ArrayList<>(hm.entrySet());
        sortedStock.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        String [] ans = new String[3];
        for (int i = 0; i < 3; i++) {
            ans[i] = sortedStock.get(i).getKey();
        }
        return ans;
    }
}
