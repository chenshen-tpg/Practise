package LC_Questions.CollectionAll.BitManipulation.DailyChanllenges;

public class NeighboringBitWiseXOR_2683 {
    public static void main(String[] args) {
        int [] d1 = {1,0};
        System.out.println(wdym(d1));
    }
    public static boolean wdym (int[] derived) {
        int n = derived.length;
        int [] temp = new int [n];

        for (int i = 0; i < derived.length; i++) {
            if (i == n - 1) {
                temp[i] = derived[i] ^ derived[0];
            } else {
                temp[i] = derived[i] ^ derived[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] != derived[i]) {
                return false;
            }
        }
        return true;
    }
}
