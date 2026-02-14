package SlidingWindow;

import java.util.HashMap;

public class MaximumSubArrayDistinct {
    public static void main(String[] args) {
        int[] array = {4,4,4};
        int k = 2;
        System.out.println(maximumSubArraySum(array, k));
    }

    public static long maximumSubArraySum(int[] nums, int k) {
        int prev = 0, sum = 0;
        long total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.isEmpty() || !map.containsKey(nums[i]) || map.get(nums[i]) <= prev){
                sum += nums[i];
                map.put(nums[i], i);
            }
            else{
                sum -= nums[prev];
                prev = map.get(nums[i]) + 1;
            }
            while(i - prev + 1 > k) {
                sum -= nums[prev];
                prev++;
            }
            if(i - prev + 1 == k) {
                total = Math.max(sum, total);
            }
        }
        return total;
    }
}
