package LC_Questions.CollectionAll.PrefixSum.DailyChanllenges.CountPrefixAndSuffixPairsI_3042;

public class CountPrefixAndSuffixPairsI_3042 {
    public static void main(String[] args) {
        String [] words = {"a","aba","ababa","aa"} ;
        countPrefixSuffixPairs(words);
    }
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) continue;
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}
