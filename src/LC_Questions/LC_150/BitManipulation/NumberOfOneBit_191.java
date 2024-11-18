package LC_Questions.LC_150.BitManipulation;

public class NumberOfOneBit_191 {
    public static void main(String[] args) {
        NumberOfOneBit_191 no = new NumberOfOneBit_191();
        System.out.println(no.hammingWeight(11));
    }

    private boolean hammingWeight(int i) {
        return Integer.bitCount(i) == 1;
    }


}
