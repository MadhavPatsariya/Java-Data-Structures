package SlidingWindow;

import java.util.Arrays;

public class MinimizeMaxDifference {
    public static void main(String[] args) {
        MinimizeMaxDifference maxDifference = new MinimizeMaxDifference();
        int[] nums = {4,2,1,2};
        //
        int p = 2;
        System.out.println("maxDiff: " + maxDifference.minimizeMax(nums, p));
    }

    public int minimizeMax(int[] nums, int p) {
        if(nums.length == 0 || p == 0) {
            return 0;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
//        for(int i = 0; i <= (nums.length - (2 * p)); i++) {
//            min = Math.min(min, findMinimumMax(nums, p, i));
//        }
        return findMinimumMax(nums, p, 0);
//        return min;
    }

    public int findMinimumMax(int[] nums, int p, int i) {
        if(p == 0) {
            return 0;
        }
        if(i + 1 >= nums.length) {
            return Integer.MAX_VALUE;
        }
        int diff = Math.abs(nums[i] - nums[i + 1]);
        int skipCurrent = findMinimumMax(nums, p, i + 1);
        int takeCurrent = findMinimumMax(nums, p - 1, i + 2);
        if(takeCurrent != Integer.MAX_VALUE) {
            takeCurrent = Math.max(diff, takeCurrent);
        }
        return Math.min(takeCurrent, skipCurrent);
    }
}
