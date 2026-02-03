package CodingQuestions.Algorithms.Array.ArrayGeneral.TrionicArray_3637;

public class test {

    public static void main(String[] args) {
        int [] c = new int [] {4,1,5,2,3};
        test obj = new test();
        obj.isTrionic(c);
    }

    public boolean isTrionic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        boolean inca = false;
        int point1 = nums.length;
        int point2 = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (!inc && nums[i] > nums[i - 1]) {
                inc = true;
                point1 = i;
            }
            else if (!dec && i > point1 && nums[i] < nums[i - 1]) {
                dec = true;
                point2 = i;
            }
            else if (i > point2 && nums[i] > nums[i - 1]) {
                inca = true;
            }
        }
        return inc && dec && inca;
    }
}
