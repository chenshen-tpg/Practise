package CodingQuestions.Array.ArrayGeneral.Others.CrawlerLog_1598;

public class TEST {
    public static void main(String[] args) {

    }
    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (log.charAt(1) == '.') {
                if (level > 0) level--;
            }
            else if (log.charAt(0) == '.') continue;
            else level++;
        }
        return level;
    }
}
