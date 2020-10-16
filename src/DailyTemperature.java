import java.util.Stack;

public class DailyTemperature {

    public static void main(String args[]){
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(nums);

        for(int val : res){
            System.out.print(val + " ");
        }

    }

    public static int[] dailyTemperatures(int[] temper){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        for(int i = 0; i < temper.length; i++){

            while(!stack.empty() && (temper[stack.peek()] < temper[i]) ){
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }


        return result;
    }
}
