package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _929_Unique_mail_Addresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> validEmail = new HashSet<>();
        for (String email : emails) {
            int nonePlus = email.indexOf('@');
            int plus = email.indexOf('+');
            String rs = "";

            if (plus > 0) {
                rs = email.substring(0, plus);
            } else {
                rs = email.substring(0, nonePlus);
            }

            rs = rs.replace(".", "") + email.substring(nonePlus);

            validEmail.add(rs);
            System.out.println(rs);
        }
        return validEmail.size();
    }

    public static void main(String[] args) {
        String email = "alice.z@leetcode.com";
        int index = email.indexOf('@');
        String localName = email.substring(0, index);
        String domainName = email.substring(index);
        localName = localName + "1";
        System.out.println(localName);
        System.out.println(domainName);
    }
}
