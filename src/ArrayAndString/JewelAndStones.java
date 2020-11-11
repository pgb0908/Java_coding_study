package ArrayAndString;

import java.util.HashSet;
import java.util.Set;

public class JewelAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        
        System.out.println(solv(J, S));
    }

    private static int solv(String jew, String stone) {
        // hashSet을 이용할 거임 - 중복을 허용하지 않음!!
        Set<Character> set = new HashSet<>();

        // jewel을 등록
        for(char je : jew.toCharArray()){
            set.add(je);
        }

        // stone에서 jew을 확인
        int cnt = 0;
        for(char st : stone.toCharArray()){
            if(set.contains(st)){
                cnt++;
            }
        }

        return cnt;
    }
}
