package CodingQuestions.Hash.MinimumDeletionsToKSpecial_3085;

public class Array {
    public static void main(String[] args) {
        minimumDeletions("dabdcbdcdcd", 2);
    }
    public static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            if(freq[i] == 0) continue;
            int max = freq[i] + k;
            int ans = 0;
            //1235，2
            for(int j=0;j<freq.length;j++){
                if(freq[j] < freq[i]) ans = ans + freq[j];
                else if(freq[j] > max) ans = ans + freq[j] - max;
            }
            min = Math.min(min, ans);
        }
        return min;
    }
}
