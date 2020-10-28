public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int newSum = 0;
        int max = nums[0];

        for(int i =0; i < nums.length; i++){
            newSum = Math.max(nums[i], newSum + nums[i]);  // 연속되는 합이 기존 하나의 값보다 큰가
            max = Math.max(newSum, max);  // 계속해서 max 업데이트
        }

        return max;
    }
}
