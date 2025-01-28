package LC_Questions.CollectionAll.PrefixSum.Others;

public class CountingWordsWithaGivenPrefix_2185 {
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
