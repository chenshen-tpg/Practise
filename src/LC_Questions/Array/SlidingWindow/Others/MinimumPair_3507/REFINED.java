package LC_Questions.Array.SlidingWindow.Others.MinimumPair_3507;

import java.util.ArrayList;
import java.util.List;

public class REFINED {
    public static void main(String[] args) {

    }
    public int minimumOperationsRefined(int[] nums) {
        int operations = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        while (list.size() > 1) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                int sum = list.get(minIndex) + list.get(minIndex + 1);
                list.remove(minIndex + 1);
                list.set(minIndex, sum);
                operations++;
                if (isNonDecreasing(list)) {
                    break;
                }
            } else {
                break;
            }
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
