package LC_Questions.Array.ArrayGeneral.Others.CountAndSay_38;

public class Linear2 {
    public String countAndSay(int n) {
        String currentString = "1";
        for (int i = 2; i <= n; i++) {
            String nextString = "";
            for (int j = 0, k = 0; j < currentString.length(); j = k) {
                while (
                        k < currentString.length() &&
                                currentString.charAt(k) == currentString.charAt(j)
                ) k++;
                nextString += Integer.toString(k - j) + currentString.charAt(j);
            }
            currentString = nextString;
        }
        return currentString;
    }
}
