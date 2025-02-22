package LC_Questions.CollectionAll.BackTracking.Others;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences_2002 {
    int res = 0;

    public static void main(String[] args) {
        MaximumProductOfTheLengthOfTwoPalindromicSubsequences_2002 mp = new MaximumProductOfTheLengthOfTwoPalindromicSubsequences_2002();
        System.out.println(mp.maxProduct("leetcodecom"));
    }
    public int maxProduct(String s) {
        char[] strArr = s.toCharArray();
        dfs(strArr, 0, "", "");
        return res;
    }

    public void dfs(char[] strArr, int i, String s1, String s2){
        if(i >= strArr.length){
            if(isPalindromic(s1) && isPalindromic(s2)) {
                res = Math.max(res, s1.length() * s2.length());
            }
            return;
        }
        dfs(strArr, i+1, s1 + strArr[i], s2);
        dfs(strArr, i+1, s1, s2 + strArr[i]);
        dfs(strArr, i+1, s1, s2);
    }

    public boolean isPalindromic(String str){
        char[] strArr = str.toCharArray();
        int j = str.length();
        for (int i = 0; i < j / 2; i ++){
            if (strArr[i] != strArr[j - i - 1])
                return false;
        }
        return true;
    }
}
