package DP;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        String p = "c*a*b", s = "aab";
        System.out.println(wildcardMatching.isMatch(s, p));
    }

    public boolean isMatch(String p, String s) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return isMatching(dp, s, p, n - 1, m - 1);
    }

    public boolean isMatching(int[][] dp, String s, String p, int i, int j) {
        if(i < 0 && j >= 0) {
            return false;
        }
        if(j < 0){
            for(int x = i; x >= 0; x--){
                if(s.charAt(x) != '*') {
                    return false;
                }
            }
            return true;
        }
        if(i < 0 && j < 0) {
            return true;
        }
        if(dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if(s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') {
            dp[i][j] = isMatching(dp, s, p, i - 1, j - 1) ? 1 : 0;
        }
        else if(s.charAt(i) == '*') {
            //flag = (* matches with empty, thus remove *) || (* matches with character);
            boolean flag = isMatching(dp, s, p, i - 1, j) || isMatching(dp, s, p, i, j - 1);
            dp[i][j] = flag ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}
