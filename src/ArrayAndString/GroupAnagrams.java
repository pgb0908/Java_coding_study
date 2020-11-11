package ArrayAndString;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    private static List<List<String>> groupAnagrams(String[] list) {
        List<List<String>> result = new ArrayList<>();
        if(list == null || list.length == 0) return result;

        // 자료구조를 만든다
        Map<String, List<String>> map = new HashMap<>();

        // sort을 해서 하나의 기준을 만든다
        // 그리고 자료구조에 넣는다
        for(String str : list){
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            String key = String.valueOf(charStr);
            System.out.println(key);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                // 키가 없으면 map에 넣음
                List<String> newStr = new ArrayList<>();
                newStr.add(str);
                map.put(key, newStr);
            }
        }

        result.addAll(map.values());
        return result;
    }
}
