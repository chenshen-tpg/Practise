package LC_Questions.Array.Others.UniqueEmailAddress;

import java.util.HashSet;

public class Set {
    public static void main(String[] args) {
        Set memoryExceed = new Set();
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        int result = memoryExceed.numUniqueEmails(emails);
        System.out.println("Number of unique emails: " + result); // Expected output: 2
    }
    public int numUniqueEmails(String[] emails) {
        java.util.Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            set.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}
