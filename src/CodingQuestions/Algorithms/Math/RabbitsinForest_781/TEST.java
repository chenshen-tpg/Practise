package CodingQuestions.Algorithms.Math.RabbitsinForest_781;

public class TEST {
    public static void main(String[] args) {

    }
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;
        int ans = 0;
        for (int k = 0; k < 1000; ++k)
            ans += Math.floorMod(-count[k], k+1) + count[k];
        return ans;
    }
}
