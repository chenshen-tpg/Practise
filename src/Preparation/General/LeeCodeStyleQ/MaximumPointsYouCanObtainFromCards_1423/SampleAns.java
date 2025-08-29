<<<<<<<< HEAD:src/Preparation/Specific/Canava/Programming/MaximumPointsYouCanObtainFromCards_1423/SampleAns.java
package Preparation.Specific.Canava.Programming.MaximumPointsYouCanObtainFromCards_1423;
========
package Preparation.General.LeeCodeStyleQ.MaximumPointsYouCanObtainFromCards_1423;
>>>>>>>> origin/master:src/Preparation/General/LeeCodeStyleQ/MaximumPointsYouCanObtainFromCards_1423/SampleAns.java

public class SampleAns {

    public static void main(String[] args) {

    }

    public int maxScore(int[] cards, int k) {
        int total = 0;
        for (int card : cards) {
            total += card;
        }
        if (k >= cards.length) {
            return total;
        }
        int temp = 0;
        int max = 0;
        int j = 0;
        for (int i = 0; i < cards.length; i++) {
            temp += cards[i];
            if (i - j + 1 == cards.length - k) {
                max = Math.max(total - temp, max);
                temp -= cards[j++];
            }
        }

        return max;
    }
}
