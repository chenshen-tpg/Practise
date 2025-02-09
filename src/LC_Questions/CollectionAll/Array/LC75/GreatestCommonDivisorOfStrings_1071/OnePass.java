package LC_Questions.CollectionAll.Array.LC75.GreatestCommonDivisorOfStrings_1071;

public class OnePass {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
//        System.out.println(str1.substring(str2.length()));begin index
        System.out.println(gcdOfStrings(str1, str2));
    }



    public static String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);
        if (str2.equals(str1)) return str2;
        if (str1.startsWith(str2)) return gcdOfStrings(str1.substring(str2.length()), str2);
        return "";
    }
}
