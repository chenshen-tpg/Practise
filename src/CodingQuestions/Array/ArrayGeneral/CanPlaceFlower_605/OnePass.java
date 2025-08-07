package CodingQuestions.Array.ArrayGeneral.CanPlaceFlower_605;

public class OnePass {
    public static void main(String[] args) {
        int [] flower = {1,0,0,0,1};
        int n = 1;
        OnePass solution = new OnePass();
        System.out.println(solution.canPlaceFolower(flower, n));
    }
    public boolean canPlaceFolower(int [] flowerbed, int n) {
        int place = 0, len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    place++;
                }
            }
        }
        return place >= n;
    }

}
