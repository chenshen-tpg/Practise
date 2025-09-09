package CodingQuestions.Algorithms.Array.ArrayGeneral.CountAndSay_38;

public class Linear {
    public static void main(String[] args) {
        Linear solution = new Linear();
        System.out.println(0 % 2);
        solution.countAndSay(4);
    }

    /***
     n = 1: "1"
     n = 2: Read "1" as "one 1" -> "11"
     n = 3: Read "11" as "two 1s" -> "21"
     n = 4: Read "21" as "one 2, one 1" -> "1211"
     n = 5: Read "1211" as "one 1, one 2, two 1s" -> "111221"
     */
    public String countAndSay(int n) {
        int count;
        char say;
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}
