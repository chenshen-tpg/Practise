package CodingQuestions.Algorithms.BackTracking.TupleWithSameProduct_1726;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeTrying {

    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        int [] nums = {2,3,4,6};
        solution.helper(nums);
    }

    public int helper (int [] nums) {
        int n = nums.length;
        List<Integer> pairProducts = new ArrayList<>();
        int totalNumberOfTuples = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++ ) {
                pairProducts.add(nums[i] * nums[j]);
            }
        }
        Collections.sort(pairProducts);
        int lastProductSeen = -1;
        int sameProductCount = 0;

        for (int i = 0; i < pairProducts.size();i++) {
            if (pairProducts.get(i) == lastProductSeen) {
                sameProductCount++;
            } else {
                int pairsOfEqualProduct = ((sameProductCount - 1) * sameProductCount) / 2;
                totalNumberOfTuples += 8 * pairsOfEqualProduct;
                lastProductSeen = pairProducts.get(i);
                sameProductCount = 1;
            }
        }
        int pairsOfEqualProduct = ((sameProductCount - 1) * sameProductCount) / 2;
        totalNumberOfTuples += 8 * pairsOfEqualProduct;

        return totalNumberOfTuples;
    }
}
