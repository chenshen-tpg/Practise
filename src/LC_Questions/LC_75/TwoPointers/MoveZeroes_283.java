package LC_Questions.LC_75.TwoPointers;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        MoveZeroes_283 mz = new MoveZeroes_283();
        int [] test = new int []{0,1,0,3,12};
        mz.moveZeroes(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    private void moveZeroes(int[] ints) {
        int left = 0;
        for(int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                ints[left++] = ints[i];
            }
        }
        while (left < ints.length) {
            ints[left++] = 0;
        }
    }

}
