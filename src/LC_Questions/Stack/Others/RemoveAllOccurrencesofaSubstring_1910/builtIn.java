package LC_Questions.Stack.Others.RemoveAllOccurrencesofaSubstring_1910;

public class builtIn {
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(RemoveAllOccurrences(s, part));
    }

    public static String RemoveAllOccurrences(String s, String part) {
        while (s.contains(part)){
            s = s.substring(0, s.indexOf(part)) + s.substring(s.indexOf(part) + part.length(), s.length());
        }
        return s;
    }
}
