package DP;

public class NumberOfLIS {
    public static void main(String[] args) {
        NumberOfLIS numberOfLIS = new NumberOfLIS();
        int[] nums = {1,3,5,4,7};
        System.out.println(numberOfLIS.findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] count = new int[N];
        int max = 1;
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            max = Math.max(dp[i], max);
        }
        int nos = 0;
        for(int i = 0; i < N; i++) {
            if(max == dp[i]) {
                nos += count[i];
            }
        }
        return nos;
    }
}
