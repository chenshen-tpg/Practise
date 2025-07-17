package CodingQuestions.Hash.Others.MinimumLengthOfStringAfterOperations_3223;

public class Memo {

    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(linear(s));
    }

    //For some operation related challenges, the pattern might be a calculation of even || odd
    public static int linear (String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;
        for (char currentChar : s.toCharArray()) {
            charFrequency[currentChar - 'a']++;
        }
        for (int frequency : charFrequency) {
            if (frequency == 0) continue;
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }
}
