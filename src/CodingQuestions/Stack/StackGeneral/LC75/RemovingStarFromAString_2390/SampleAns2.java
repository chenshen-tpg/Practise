package CodingQuestions.Stack.StackGeneral.LC75.RemovingStarFromAString_2390;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public String removeStars(String s) {
        int len = s.length(), count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >=0; i--) {
            char cur = s.charAt(i);
            if (cur == '*') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            sb.append(cur);
        }
        return sb.reverse().toString();
    }
}
