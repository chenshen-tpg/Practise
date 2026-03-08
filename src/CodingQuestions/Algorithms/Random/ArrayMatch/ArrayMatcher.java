package CodingQuestions.Algorithms.Random.ArrayMatch;

public class ArrayMatcher {
    private final String target;

    public ArrayMatcher(String target) {
        this.target = target;
    }

    public boolean isValid(String input) {
        if (input == null || target == null || input.length() != target.length() + 1) {
            return false;
        }
        int[] charCounts = new int[256];
        for (int i = 0; i < target.length(); i++) {
            charCounts[target.charAt(i)]++;
        }
        for (int i = 0; i < input.length(); i++) {
            charCounts[input.charAt(i)]--;
        }
        int missingCount = 0;
        for (int count : charCounts) {
            if (count == -1) {
                missingCount++;
            } else if (count != 0) {
                return false;
            }
        }
        return missingCount == 1;
    }

    public static void main(String[] args) {
        ArrayMatcher matcher = new ArrayMatcher("temp");
        System.out.println("OOBempta: " + matcher.isValid("empta"));
        System.out.println("tempp: " + matcher.isValid("tempp"));
        System.out.println("temaa: " + matcher.isValid("temaa"));
        System.out.println("abcde: " + matcher.isValid("abcde"));
    }
}