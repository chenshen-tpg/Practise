package LC_Questions.Math.Others.UglyNumII_264;

import java.util.TreeSet;

public class TEST {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        Long temp = 1L;
        for (int i = 0; i < n; i++) {
            temp = set.pollFirst();
            set.add(temp * 2);
            set.add(temp * 3);
            set.add(temp * 5);
        }
        return temp.intValue();
    }
}
