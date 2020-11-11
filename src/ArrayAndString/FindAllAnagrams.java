package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(findAnagrams(txt, pat));
    }

    private static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();

        // 체크
        if(txt == null || txt.length() == 0 ||
            pat == null || pat.length() == 0 ||
                pat.length() > txt.length()) return result;

        int[] patArr = new int[256];
        for(int i=0; i < pat.length(); i++){
            patArr[pat.charAt(i)]++;
        }

        for(int i=0; i < txt.length() -pat.length()+1; i++){
            int[] txtArr = new int[256];
            for(int j = 0; j < pat.length(); j++){
                txtArr[txt.charAt(i + j)]++;
            }

            if(isAnagram(patArr, txtArr)){
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isAnagram(int[] patArr, int[] txtArr) {
        for(int i = 0; i < txtArr.length; i++){
            if(txtArr[i] != patArr[i]) return false;
        }

        return true;
    }
}
