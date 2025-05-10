package LC_Questions.Array.ArrayGeneral.Others.CrawlerLog_1598;

public class Sample {
    public static void main(String[] args) {

    }

    public int minOperations(String[] logs) {
        int counter = 0;
        for (String log : logs) {
            counter = counter + evaluateLog(log);
            if (counter < 0) {
                counter = 0;
            }
        }
        return counter;
    }

    public int evaluateLog(String log) {
        if (log.charAt(1) == '.') {
            return -1;
        } else if (log.charAt(0) == '.') {
            return 0;
        } else {
            return 1;
        }
    }
}
