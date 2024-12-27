package LC_Questions.LC_150.Array;


public class RemoveDuplicatesfromSortedArrayII_80 {
    public static void main(String[] args) {
        method1();
        method2();
    }
    public static void method1(){
        int [] a = {1,1,1,2,2,3};
        int index = 0;
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] == a[i-1]) {
                count++;
            } else {
                count=0;
            }
            if (count < 2){
                a[index++] = a[i];
            }
        }
        printOut(a);
    }
    public static void method2(){
        int [] a = {1,1,1,2,2,3};
        int i = 1;
        int j = 1;
        int count = 0;
        while (i < a.length) {
            if (a[i] == a[i-1]) {
                count++;
                if (count > 1) {
                    i++;
                }
            } else {
                count = 0;
            }
            a[j] = a[i];
            i++;
            j++;
        }
        printOut(a);
    }
    public static void printOut(int[] a){
        for (Integer i:a) {
            System.out.print(i+" ");
        }
    }
}
