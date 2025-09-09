package CodingQuestions.Algorithms.Math.MaximumSwap_670;

public class Swap {
    public static void main(String[] args) {

    }
    private static int method(int num) {
        char [] numStr = Integer.toString(num).toCharArray();
        int maxDig = -1, fIndex = -1, sIndex = -1;
        for (int i = numStr.length - 1; i >= 0; i --) {
            if (maxDig == -1 || numStr[i] > numStr[maxDig]) maxDig = i;
            else if (numStr[i] < numStr[maxDig]) {
                fIndex = i;
                sIndex = maxDig;
            }
        }
        if (fIndex != -1 && sIndex != -1) {
            char temp = numStr[fIndex];
            numStr[fIndex] = numStr[sIndex];
            numStr[sIndex] = temp;
        }
        return Integer.parseInt(new String(numStr));
    }
}
