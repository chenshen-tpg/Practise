package CodingQuestions.Array.BitManipulation.ReverseBits_190;

public class ReverseBits_190 {
    public static void main(String[] args) {
        ReverseBits_190 rb = new ReverseBits_190();
        System.out.println(rb.reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }
    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
