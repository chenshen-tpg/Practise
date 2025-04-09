package LC_Questions.Array.Others.UniqueEmailAddress;

import java.util.HashSet;

public class MemoryExceed {
    public static void main(String[] args) {
        MemoryExceed memoryExceed = new MemoryExceed();
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        int result = memoryExceed.numUniqueEmails(emails);
        System.out.println("Number of unique emails: " + result); // Expected output: 2
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet();
        for (String email : emails) {
            int indexAt = email.indexOf('@');
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '.' && i < indexAt) {
                    continue;
                } else if (email.charAt(i) == '+') {
                    i = indexAt;
                }
                temp.append(email.charAt(i));
            }
            hs.add(temp.toString());
        }
        return hs.size();
    }
}
