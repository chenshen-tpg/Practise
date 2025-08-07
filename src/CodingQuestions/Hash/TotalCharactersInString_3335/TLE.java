package CodingQuestions.Hash.TotalCharactersInString_3335;

public class TLE {
    public static void main(String[] args) {
        lengthAfterTransformations("v", 7);
    }
    public static int lengthAfterTransformations(String s, int t) {
        StringBuilder sb = new StringBuilder(s);
        while (t > 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) - 'a' == 25) {
                    temp.append("ab");
                } else {
                    temp.append((char)(sb.charAt(i) + 1));
                }
            }
            t--;
            sb = temp;
        }
        return sb.length() % 1000000007;
    }
}
