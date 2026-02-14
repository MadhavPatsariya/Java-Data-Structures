package DP;

import java.util.Arrays;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII partitioningII = new PalindromePartitioningII();
        String s = "aab";
        System.out.println(partitioningII.minCut(s));
    }

    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return findCut(dp, s, 0);
    }

    public int findCut(int[] dp, String s, int i) {
        if(i == s.length()) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s.substring(i, j + 1))) {
                int cost = 1 + findCut(dp, s, j + 1);
                min = Math.min(cost, min);
            }
        }
        dp[i] = min;
        return dp[i];
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
