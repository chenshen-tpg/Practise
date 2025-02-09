package LC_Questions.CollectionAll.TwoPointers.LC75.MoveZeros;

public class OnePass {
    public static void main(String[] args) {
        OnePass mz = new OnePass();
        int [] test = new int []{0,1,0,3,12};
        mz.moveZeroes2(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    private void moveZeroes2(int [] ints) {
        int k = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                ints[k++] = ints[i];
            }
        }
        while(k < ints.length){
            ints[k++] = 0;
        }
    }
}
