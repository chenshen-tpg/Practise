package CompanySpecific.Canava.ProgrammingQuestions;



import java.util.HashSet;

public class findLongetSubStringWithoutRepeatCharacter {
    public static void main(String[] args) {
        findLongetSubStringWithoutRepeatCharacter solution = new findLongetSubStringWithoutRepeatCharacter();
        System.out.println(solution.helper("abcdefghiiiiiijk"));
    }

    public int helper (String test) {
        int len = test.length();
        int ans = 0, temp = 0;
        HashSet<Character> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < test.length(); i++) {
            while (set.contains(test.charAt(i))) {
                set.remove(test.charAt(index));
                index++;
            }
            set.add(test.charAt(i));
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }
}
