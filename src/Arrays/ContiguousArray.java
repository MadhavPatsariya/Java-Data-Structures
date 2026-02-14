package Arrays;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(array));
    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if(prefix.containsKey(sum)) {
                int index = prefix.get(sum);
                max = Math.max(max, i - index);
            }
            else{
                prefix.put(sum, i);
            }
        }
        return max - 1;
    }
}
