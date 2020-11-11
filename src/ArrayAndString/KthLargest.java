package ArrayAndString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest a = new KthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(a.solve_array(nums, k));
        System.out.println(a.solve_pq(nums2, k));

        for(int val : nums ){
            System.out.print(val + " ");
        }
    }

    private int solve_pq(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length - k];
    }

    private int solve_array(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);

        for(int val : nums){
            pq.add(val);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
