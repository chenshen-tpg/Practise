package CodingQuestions.Algorithms.Array.ArrayGeneral.IntersectionOfTwoArray_350;

public class Memo {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int [] memo1 = new int [1001];
        int [] memo2 = new int [1001];
        int count = 0;
        for (int num : nums1) {
            memo1[num]++;
        }
        for (int num : nums2) {
            memo2[num]++;
        }
        for (int i = 0; i < 1001; i++) {
            if (memo1[i] != 0 && memo2[i] !=0) {
                count += Math.min(memo1[i], memo2[i]);
            }
        }
        int index = 0;
        int [] ans = new int [count];
        for (int i = 0; i < 1001; i++) {
            if (memo1[i] != 0 && memo2[i] !=0) {
                int temp = Math.min(memo1[i], memo2[i]);
                while (temp > 0) {
                    ans[index++] = i;
                    temp--;
                }
            }
        }
        return ans;
    }
}
