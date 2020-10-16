import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[]){
        int[] nums = {2, 8, 11, 21, 7};
        int target = 15;

        TwoSum example = new TwoSum();
        int[] result = example.solver(nums, target);

        for(int val : result){
            System.out.print(val + " ");
        }

    }

    public int[] solver(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int mapValue = map.get(nums[i]);
                result[0] = mapValue + 1;
                result[1] = i + 1;
            } else{
                map.put(target - nums[i], i); // key 10-2=8, value i=0
            }
        }

        return result;
    }
}
