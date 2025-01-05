package Basic.TEST;

public class testSomeThing {
    public static void main(String[] args) {
        int [] sss = {1,2,3,4,5,6,7,8};
        int [] newSss = new int [sss.length];
        int l = 0, r = sss.length;

        int index = 0;
        int rindex = sss.length - 1;
        for (int i = 0; i < sss.length ; i++) {
            if (sss[i] % 2 != 0) {
                newSss[index++] = sss[i];
            } else {
                newSss[rindex--] = sss[i];
            }
        }
        for (int i = 0; i < newSss.length; i++) {
            System.out.println(newSss[i]);
        }
    }
}
