public class PlusOne {
    public static void main(String[] args) {
        // int[] digits = {1,2,3}; //124
         int[] digits = {9,9,9}; //1000
        // int[] digits = {0,0,1}; //002

        int[] result = solve(digits);

        for(int i : result){
            System.out.print(i);
        }
    }

    private static int[] solve(int[] digits) {

        // for - 꺼꾸로 진입
        int len = digits.length;
        for(int i = len-1; i >= 0; i--){
            // 뒷자리를 체크해서 9가 아닌 경우 단순히 1만 증가
            if(digits[i] != 9) {
                digits[i]++;
                break;
           }else{
               digits[i] = 0;
            }

            if(digits[0] == 0){
                int[] result = new int[len+1];
                result[0] = 1;
                return result;
            }
        }

        return digits;
    }
}
