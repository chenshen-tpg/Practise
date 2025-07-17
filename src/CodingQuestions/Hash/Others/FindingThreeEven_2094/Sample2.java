package CodingQuestions.Hash.Others.FindingThreeEven_2094;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    public int[] findEvenNumbers(int[] digits) {

        int[] frequencies = new int[10];
        for (int digit : digits) {
            frequencies[digit]++;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 100; i <= 998; i = i + 2) {
            int a = i % 10;
            int b = (i / 10) % 10;
            int c = (i / 100) % 10;
            int[] tempFrequency = new int[10];
            tempFrequency[a]++;
            tempFrequency[b]++;
            tempFrequency[c]++;

            if (tempFrequency[a] <= frequencies[a] && tempFrequency[b] <= frequencies[b] && tempFrequency[c] <= frequencies[c]) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(i -> i).sorted().toArray();
    }
}
