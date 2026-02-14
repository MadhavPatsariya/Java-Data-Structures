package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LDS {
    public static void main(String[] args) {
        LDS lds = new LDS();
        int[] nums = {7, 8, 1, 9, 10, 4};
        System.out.println(lds.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] hash = new int[N];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        for(int i = 0; i < N; i++) {
            hash[i] = i;
        }
        int max = 1;
        int max_idx = 0;
        for(int i = 0; i < N; i++) {
            for(int p = 0; p < i; p++) {
                if(((nums[i] % nums[p] == 0)|| nums[p] % nums[i] == 0 ) && dp[i] < dp[p] + 1) {
                    dp[i] = dp[p] + 1;
                    hash[i] = p;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
                max_idx = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>(max);
        for(int i = 0; i < max; i++) {
            list.add(0);
        }
        int idx = max - 1;
        int i = max_idx;
        while(hash[i] != i) {
            list.set(idx--, nums[i]);
            i = hash[i];
        }
        list.set(idx, nums[i]);
        return list;
    }
}
