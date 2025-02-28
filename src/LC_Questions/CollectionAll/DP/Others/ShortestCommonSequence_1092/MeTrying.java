package LC_Questions.CollectionAll.DP.Others.ShortestCommonSequence_1092;

public class MeTrying {
    public static void main(String[] args) {
//        Input: str1 = "abac", str2 = "cab"
        MeTrying solution = new MeTrying();
        solution.helper("abac", "cab");
    }

    private String helper(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) return "";
        if (str1.isEmpty()) return str2;
        if (str2.isEmpty()) return str1;
        if (str1.charAt(0) == str2.charAt(0)) return (str1.charAt(0) + helper(str1.substring(1), str2.substring(1)));
        else {
            String pickStr1 = str1.charAt(0) + helper(str1.substring(1), str2);
            String pickStr2 = str2.charAt(0) + helper(str1, str2.substring(1));
            return (pickStr1.length() < pickStr2.length()) ? pickStr1 : pickStr2;
        }
    }
}
