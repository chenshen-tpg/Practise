package CodingQuestions.Array.BitManipulation.Ohters.Test;

public class XOR {
    //Bitwise Operations:
    public static void main(String[] args) {
        int a = 5;  // Binary: 0101
        int b = 3;  // Binary: 0011

        // XOR operation
        int result = a ^ b;  // Binary: 0110, Decimal: 6

        System.out.println("a ^ b = " + result);

        // XOR with the same number
        int c = 7;  // Binary: 0111
        int d = 7;  // Binary: 0111

        int result2 = c ^ d;  // Binary: 0000, Decimal: 0

        System.out.println("c ^ d = " + result2);

        // XOR with zero
        int e = 10;  // Binary: 1010
        int f = 0;   // Binary: 0000

        int result3 = e ^ f;  // Binary: 1010, Decimal: 10

        System.out.println("e ^ f = " + result3);
    }
}
