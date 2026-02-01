package CodingQuestions.Algorithms.Array.BitManipulation.NeighorBitWise_2683;

public class NotSureWhatThisIs {
    /***
     A 0-indexed array derived with length n is derived by computing the bitwise XOR (⊕) of adjacent values in a binary array original of length n.

     Specifically, for each index i in the range [0, n - 1]:

     If i = n - 1, then derived[i] = original[i] ⊕ original[0].
     Otherwise, derived[i] = original[i] ⊕ original[i + 1].
     Given an array derived, your task is to determine whether there exists a valid binary array original that could have formed derived.

     Return true if such an array exists or false otherwise.

     A binary array is an array containing only 0's and 1's
     */
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
