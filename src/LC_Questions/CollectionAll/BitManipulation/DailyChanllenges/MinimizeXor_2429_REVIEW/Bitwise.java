package LC_Questions.CollectionAll.BitManipulation.DailyChanllenges.MinimizeXor_2429_REVIEW;

public class Bitwise {
    public static void main(String[] args) {
        int num = 3; // Binary: 00000011
        int shifted = num << 2; // Binary: 00001100 (3 * 2^2 = 12)
        System.out.println("Shifted: " + shifted); // Output: 12

        int a = 5; // Binary: 00000101
        int b = 3; // Binary: 00000011
        a |= b; // Binary: 00000111 (5 | 3 = 7)
        System.out.println("Result after |= : " + a); // Output: 7


        int a1 = 5;  // Binary: 0101
        int b1 = 3;  // Binary: 0011
        int result = a1 & b1;  // Binary: 0001 (only the last bit is 1 in both a and b)
        System.out.println(result);  // Output: 1


        int result1 = 5; // Binary: 0101
        int i = 1;
        if ((result1 & (1 << i)) == 0) {
            System.out.println("The " + i + "-th bit is not set.");
        }

        int result2 = 5; // Binary: 0101
        int i1 = 3;
        if ((result2 & (1 << i1)) != 0) {
            result2 ^= (1 << i1);
        }
        System.out.println("Result after toggling the " + i1 + "-th bit: " + result2); // Output: 5 (Binary: 0101)
    }
}
