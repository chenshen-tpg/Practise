package CodingQuestions.Algorithms.Array.BinarySearch.FindSmallestLetterGreaterThanTarget_744;

public class TEST {
    public static void main(String[] args) {

    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}
