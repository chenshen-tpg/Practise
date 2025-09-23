package CodingQuestions.Algorithms.Array.TwoPointers.CompareVersion_165;

public class TEST {
//    version1 = "1.2", version2 = "1.10"
    public static void main(String[] args) {

    }
    public int compareVersion(String version1, String version2) {
        int v1 = 0, v2 = 0;

        int v1l = version1.length(), v2l = version2.length();
        while (v1 < v1l || v2 < v2l) {
            long num1 = 0;
            long num2 = 0;
            while (v1 < v1l || version1.charAt(v1) != '.') {
                num1 = num1 * 10 + Integer.valueOf(version1.charAt(v1));
                v1++;
            }
            while (v2 < v2l || version2.charAt(v2) != '.') {
                num2 = num2 * 10 + Integer.valueOf(version2.charAt(v2));
                v2++;
            }
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            while (v1 < v1l && version1.charAt(v1) == '.') v1++;
            while (v2 < v2l && version2.charAt(v2) == '.') v2++;
        }
        return 0;
    }
}
