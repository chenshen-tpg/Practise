package LC_Questions.Array.ArrayGeneral.LC75.CanPlaceFlower_605;

public class review {
    public static void main(String[] args) {
        int [] flower = {0,0,1,0,1};
        int n = 1;

        int count = 0, len = flower.length;
        for (int i = 0; i < len; i++) {
            if (flower[i] == 0) {
                if ((i == 0 || flower[i - 1] ==0) && (i == len - 1 || flower[i + 1]==0)) {
                    flower[i] = 1;
                    count++;
                }
            }
        }
        System.out.println(count >= n);
    }
}
