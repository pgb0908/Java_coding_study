public class TrappingRainWater {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solve(nums));
    }

    private static int solve(int[] height) {
        int result = 0;
        if(height == null || height.length == 0) return result;

        int num = height.length;
        int[] left = new int[num];
        int[] right = new int[num];

        // left 벽을 구하라
        int max_left = height[0];
        left[0] = max_left;
        for(int i = 1; i < num; i++){
            if(max_left < height[i]){
                max_left = height[i];
                left[i] = max_left;
            }else{
                left[i] = max_left;
            }
        }

        // right 벽을 구하라
        int max_right = height[num - 1];
        right[num-1] = max_right;
        for(int i = num-2; i >= 0; i--){
            if(max_right < height[i]){
                max_right = height[i];
                right[i] = max_right;
            }else{
                right[i] = max_right;
            }
        }

        // 두 개의 벽 중 작은 것을 기준으로 하라
        // 물의 높이 중 벽을 빼라
        for(int i = 0; i < num; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
