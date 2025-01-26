package LC_Questions.WholePackage.Array.Others;

import java.util.ArrayList;
import java.util.HashSet;

public class CheckIfNandItsDoubleExist_1346 {
    public static void main(String[] args) {
        int [] a = {-2,0,10,-19,4,6,-8};
        checkIfExist1(a);
    }

    // wrong
    public static boolean checkIfExist(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i] * 2);
        }
        for (Integer a:arr) {
            if (al.contains(a)){
                return true;
            }
            if (a == 0 && al.get(a) > 1) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkIfExist1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
