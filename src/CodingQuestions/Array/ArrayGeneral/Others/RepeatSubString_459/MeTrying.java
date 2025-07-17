package CodingQuestions.Array.ArrayGeneral.Others.RepeatSubString_459;

public class MeTrying {
    public static void main(String[] args) {
        repeatedSubstringPattern("bb");
    }
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }
        int len = s.length(), subLen = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!temp.toString().contains(s.charAt(i) + "")) {
                subLen++;
                temp.append(s.charAt(i));
            }
            if (len % subLen != 0) return false;
        }
        int time = len / subLen;
        StringBuilder finalBuild = new StringBuilder();
        for (int i = 0; i < time; i++) {
            finalBuild.append(temp);
        }
        if (finalBuild.toString().equals(s)) {
            return true;
        } else {
            return false;
        }
    }

}
