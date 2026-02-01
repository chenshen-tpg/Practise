package CodingQuestions.Algorithms.Array.BitManipulation.NeighorBitWise_2683;

public class SimpleSol {
    public static void main(String[] args) {

    }
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int n : derived) xorSum ^= n;
        return xorSum == 0;
    }
}
