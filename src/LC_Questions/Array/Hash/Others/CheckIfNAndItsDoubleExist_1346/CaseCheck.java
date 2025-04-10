package LC_Questions.Array.Hash.Others.CheckIfNAndItsDoubleExist_1346;

import java.util.HashSet;
import java.util.Set;

public class CaseCheck {
    public static void main(String[] args) {
        checkIfExist(new int [] {-2,0,10,-19,4,6,-8});
    }
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> al = new HashSet<>();
        for (Integer a:arr) {
            if (al.contains(a)) return true;
            if (a % 2 == 0 && al.contains(a / 2)) return true;
            al.add(a);
        }
        return false;
    }
}
