package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] number = {5, 4, 11, 1, 16, 8};
        System.out.println(lis.getLIS(number));
    }

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N + 1][N + 1];
        for(int i = N - 1; i >= 0; i--) {
            for(int p = i - 1; p >= -1; p--) {
                int len = dp[i + 1][p + 1];
                if(p == -1 || nums[i] > nums[p]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }
                dp[i][p + 1] = len;
            }
        }
        for(int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }
        return dp[0][0];
    }

    public int getLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] address = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0; i < N; i++) {
            address[i] = i;
        }
        int max = 1;
        int max_idx = 0;
        for(int i = 0; i < N; i++) {
            for(int p = 0; p < i; p++) {
                if(nums[i] > nums[p]) {
                    if(dp[i] < dp[p] + 1) {
                        dp[i] = dp[p] + 1;
                        address[i] = p;
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                max_idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        getSequence(max_idx, nums, address, list);
        System.out.println(list);
        return max;
    }

    public void getSequence(int i, int[] nums, int[] address, List<Integer> list) {
        if(address[i] == i) {
            list.add(nums[i]);
            return;
        }
        list.add(nums[i]);
        getSequence(address[i], nums, address, list);
    }
}
