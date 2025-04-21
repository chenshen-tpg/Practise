package LC_Questions.Array.Prefix.Others.CountingWordsWithaGivenPrefix_2185;

public class Linear {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word:words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
