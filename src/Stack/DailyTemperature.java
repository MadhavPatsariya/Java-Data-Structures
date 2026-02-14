package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {30,38,30,36,35,40,28};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        stack.push(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result[i] = 0;
            }
            else{
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
