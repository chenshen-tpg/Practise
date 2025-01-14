package LC_Questions.WholePackage.Array.LC75.IncreasingTripletSubsequence_334;

public class FindTwoBiggestNum {
    public static void main(String[] args) {

    }
    public static int increasingTripletTest (int [] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        int secondBigest = Integer.MIN_VALUE;
        for (Integer num:nums) {
            if (num < smallest) {
                smallest = num;
            } else if (num < secondSmallest){
                secondSmallest = num;
            }
        }

        for (Integer num:nums) {
            if (num > biggest) {
                secondBigest = biggest;
                biggest = num;
            } else if (num > secondBigest && num != biggest){
                secondBigest = num;
            }
        }
        System.out.println(biggest);
        System.out.println(secondBigest);
        return secondSmallest;
    }
}
