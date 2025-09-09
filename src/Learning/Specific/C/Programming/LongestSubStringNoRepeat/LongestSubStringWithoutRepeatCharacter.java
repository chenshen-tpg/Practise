<<<<<<<< HEAD:src/Preparation/Specific/Canva/Programming/LongestSubStringNoRepeat/LongestSubStringWithoutRepeatCharacter.java
package Preparation.Specific.Canva.Programming.LongestSubStringNoRepeat;
========
package Learning.Specific.C.Programming.LongestSubStringNoRepeat;
>>>>>>>> origin/master:src/Learning/Specific/C/Programming/LongestSubStringNoRepeat/LongestSubStringWithoutRepeatCharacter.java



import java.util.HashSet;

public class LongestSubStringWithoutRepeatCharacter {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatCharacter solution = new LongestSubStringWithoutRepeatCharacter();
        System.out.println(solution.helper("abcdefghiiiiiijk"));
    }

    public String helper (String test) {
        int ans = 0;

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < test.length(); i++) {
            while (set.contains(test.charAt(i))) {
                set.remove(test.charAt(index));
                index++;
            }
            set.add(test.charAt(i));
            if (i - index + 1 > ans) {
                ans = i - index + 1;
                sb = new StringBuilder(test.substring(index, i + 1));
//                System.out.println(sb);
            }

        }
        return sb.toString();
    }
}
