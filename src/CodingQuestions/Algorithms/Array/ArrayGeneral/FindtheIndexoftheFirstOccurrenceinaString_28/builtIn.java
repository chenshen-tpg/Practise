package CodingQuestions.Algorithms.Array.ArrayGeneral.FindtheIndexoftheFirstOccurrenceinaString_28;

public class builtIn {
    public static void main(String[] args) {
        builtIn f = new builtIn();
        String haystack = "hello", needle = "ll";
        System.out.println(f.strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
