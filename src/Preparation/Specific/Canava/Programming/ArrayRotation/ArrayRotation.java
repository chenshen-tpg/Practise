package Preparation.Specific.Canava.Programming.ArrayRotation;

public class ArrayRotation {
    public static void main(String[] args) {
        int [] rotation = new int [] {1,2,3,4,5,6,7,8,9};
        //123456789
        //345678912
        int n = 11;
        ArrayRotation solution = new ArrayRotation();
        solution.helper(rotation,n);
    }
    public int [] helper (int [] array, int n) {
        int len = array.length;
        int rotate = n % len;
        int [] res = new int [len];
        int index = 0;
        for (int i = rotate; i <  len; i++) {
            res[index++] = array[i];
        }
        for (int i = 0; i < rotate; i++) {
            res[index++] = array[i];
        }
        return res;
    }
}
