package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDistinct {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        // 자료구조 생성
        int start = 0, end = 0, len = 0, cnt = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < s.length()){
            // map에 글자를 넣어 수를 매김
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0)+1);

            // 새로운 문자가 들어오면 cnt를 올려줌
            if(map.get(endChar) == 1){
                cnt++;
            }
            end++;

            // 2개의 문자 외에 새로운 문자가 들어오면 앞에것을 빼줌
            while(cnt > 2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar) == 0){
                    cnt--;
                }
                start++;
            }

            len = Math.max(len, end - start);
        }
        return len;
    }
}
