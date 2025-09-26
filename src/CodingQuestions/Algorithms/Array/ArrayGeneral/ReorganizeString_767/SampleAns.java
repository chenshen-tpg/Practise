package CodingQuestions.Algorithms.Array.ArrayGeneral.ReorganizeString_767;


/***
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.
***/


public class SampleAns {
    public static void main(String[] args) {
        SampleAns solution = new SampleAns();
        solution.reorganizeString("aab");
    }

    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int i, len = s.length(), maxFreq = 0, maxChar = 0;
        for (i = 0; i < 26; i++) {
            if (arr[i] > maxFreq) {
                maxFreq = arr[i];
                maxChar = i;
            }
        }

        // if more than half of the character why it cannot obtain adjacent list
        if (maxFreq > (len + 1) / 2) return "";
        char[] resArr = new char[len];
        int index = 0;

        while (arr[maxChar] > 0) {
            resArr[index] = (char) (maxChar + 'a');
            index += 2;
            arr[maxChar]--;
        }

        for (i = 0; i < 26; i++) {
            while (arr[i] > 0) {
                if (index >= len) index = 1;
                resArr[index] = (char) (i + 'a');
                index += 2;
                arr[i]--;
            }
        }
        return String.valueOf(resArr);
    }
}
