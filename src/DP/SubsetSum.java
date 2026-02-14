package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    static ArrayList<Integer> values = new ArrayList<>();
    static List<ArrayList<Integer>> complete = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println(isSubsetSum(arr, target));
        System.out.println(complete);
    }

    static Boolean isSubsetSum(int[] arr, int target) {
        int total = 0;
        int n = arr.length;
        for(int i : arr) total += i;
        int[][] dp = new int[arr.length][total];
        for(int[] i : dp) Arrays.fill(i, -1);
        return targetSum(arr, dp, n - 1, target);
    }

    static public boolean targetSum(int[] nums, int[][] dp, int index, int target) {
        if(target == 0) {
            complete.add(new ArrayList<>(values));
            return true;
        }
        if(index < 0 || target < 0) return false;
        if(index == 0) {
            if(nums[0] == target) {
                complete.add(new ArrayList<>(values));
                return true;
            }
            return false;
        }
        if(dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        boolean not = targetSum(nums, dp, index - 1, target);
        boolean take = false;
        values.add(nums[index]);
        take = targetSum(nums, dp, index - 1, target - nums[index]);
        values.removeLast();
        dp[index][target] = (not || take) ? 1 : 0;
        return (not || take);
    }
}
