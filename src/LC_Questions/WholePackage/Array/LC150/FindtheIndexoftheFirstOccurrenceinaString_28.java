package LC_Questions.WholePackage.Array.LC150;

public class FindtheIndexoftheFirstOccurrenceinaString_28 {
    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceinaString_28 f = new FindtheIndexoftheFirstOccurrenceinaString_28();
        String haystack = "hello", needle = "ll";
        System.out.println(f.strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
