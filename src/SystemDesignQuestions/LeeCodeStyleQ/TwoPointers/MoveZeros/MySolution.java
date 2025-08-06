package SystemDesignQuestions.LeeCodeStyleQ.TwoPointers.MoveZeros;

public class MySolution {
    public static void main(String[] args) {
        MySolution m = new MySolution();
        int [] test = new int []{0,1,0,3,12};
        m.moveZeroes2(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public void moveZeroes2 (int [] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {a[index++] = a[i];}
        }
        for (int i = a.length - 1; i >= index; i--) {
            a[i] = 0;
        }
    }

}
