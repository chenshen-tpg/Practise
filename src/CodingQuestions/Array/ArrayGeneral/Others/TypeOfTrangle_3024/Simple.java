package CodingQuestions.Array.ArrayGeneral.Others.TypeOfTrangle_3024;

public class Simple {
    public static void main(String[] args) {

    }
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) return "none";
        else if (nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == nums[2]) return "equilateral";
        else if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) return "isosceles";
        else return "scalene";
    }
}
