import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = { "test.email+james@coding.com",
                            "test.e.mail+toto.jane@coding.com",                    
                            "testemail+tom@cod.ing.com"};
        System.out.println(a.numuniqueEmails(emails));
    }

    private int numuniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String mail : emails){
            // 로콜 이름 가져오기
            String local = getLocalName(mail);

            // 도메인 이름 가져오기
            String domain = getDomainName(mail);

            String full = local + "@" + domain;
            System.out.println(full);
            set.add(full);
        }

        return set.size();
    }

    private String getDomainName(String mail) {
        return mail.substring(mail.indexOf("@")+1);
    }

    private String getLocalName(String mail) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < mail.length(); i++){
            if(mail.charAt(i) == '.') continue;
            if(mail.charAt(i) == '+') break;
            if(mail.charAt(i) == '@') break;

            sb.append(mail.charAt(i));
        }

        return sb.toString();
    }
}
