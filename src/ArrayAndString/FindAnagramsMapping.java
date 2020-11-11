package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = anagramMapping(A, B);

        print(result);
    }

    private static int[] anagramMapping(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[A.length];

        for(int i = 0; i < B.length; i++){
            map.put(B[i], i);
        }

        int num = 0;
        for(int key : A){
            res[num] = map.get(key);
            num++;
        }

        return res;
    }

    public static void print(int[] result) {
        for(int i=0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
