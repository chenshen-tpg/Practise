package LC_Questions.LC_75.ArrayString;

public class CanPlaceFlower_605 {
    public static void main(String[] args) {
        int[] f = {1,0,0,0,1};
        int n = 2;
        CanPlaceFlower_605 c = new CanPlaceFlower_605();
        System.out.println(c.canPlaceFlowersCorrect(f, n));
    }
    public boolean canPlaceFlowersCorrect(int[] f, int n) {
        int count = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == 0) {
                boolean left = i == 0 || f[i-1] == 0;
                boolean right = i == f.length -1 || f[i+1] == 0;
                if (left && right) {
                    f[i]=1;
                    count++;
                }
            }

        }
        return  count >= n ? true : false;
    }

}
