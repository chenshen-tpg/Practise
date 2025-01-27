package LC_Questions.CollectionAll.TwoPointers.LC75.MoveZeros;

public class Swap {
    public static void main(String[] args) {
        Swap mz = new Swap();
        int [] test = new int []{0,1,0,3,12};
        mz.swap(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    private void swap(int [] ints) {
        if (ints.length == 1) return;
        for (int i = 0; i < ints.length; i++) {
            int j = i;
            while(j + 1 < ints.length && ints[j] == 0) {
                j++;
                if (ints[j] != 0) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
    }
}
