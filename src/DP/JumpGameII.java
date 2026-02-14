package DP;
import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,0,1,4};
        System.out.println(jumpGameII.jump(nums));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return minJump(nums, 0, dp);
    }


    public int minJump(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index] && index + i < nums.length; i++) {
            int next = minJump(nums, index + i, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, next);
            }
        }

        if (min == Integer.MAX_VALUE) {
            dp[index] = Integer.MAX_VALUE;
        } else {
            dp[index] = 1 + min;
        }

        return dp[index];
    }
}
