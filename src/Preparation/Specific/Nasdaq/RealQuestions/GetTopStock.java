package Preparation.Specific.Nasdaq.RealQuestions;



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
