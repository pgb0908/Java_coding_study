public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-wabcdef";
        int k = 4;
        System.out.println(solve(str, 4));
    }

    private static String solve(String str, int k) {
        // 하이픈 삭제, 대문자로 치환
        String newStr = str.replace("-", "");
        newStr = newStr.toUpperCase();
        System.out.println(newStr);

        int len = newStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append(newStr.charAt(i));
        }
        System.out.println("sb1 : " + sb);

        // 뒤에서 4글자마다 하이픈 삽입
        for(int i = k; i < len; i=i+k){
            sb.insert(len-i, "-");
        }

        System.out.println("sb2 : " + sb);

        return sb.toString();
    }
}
