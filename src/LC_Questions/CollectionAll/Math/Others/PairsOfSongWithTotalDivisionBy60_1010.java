package LC_Questions.CollectionAll.Math.Others;

public class PairsOfSongWithTotalDivisionBy60_1010 {
    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time));
//        System.out.println(30%60);
    }

    private static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }

}
