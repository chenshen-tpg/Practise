package LC_Questions.WholePackage.Array;

public class FindtheIndexoftheFirstOccurrenceinaString_28_ez {
    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceinaString_28_ez f = new FindtheIndexoftheFirstOccurrenceinaString_28_ez();
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
