package DP;

import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {
        PrintLCS lcs = new PrintLCS();
        System.out.println("LCS: " + lcs.longestCommonSubsequence("abac", "cab"));
    }

    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int match = 0;
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    match += (1 + dp[i - 1][j - 1]);
                }
                else{
                    match += Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                dp[i][j] = match;
            }
        }
        StringBuilder str = new StringBuilder();
        int a = n, b = m;
        while(a > 0 && b > 0) {
            if(text1.charAt(a - 1) == text2.charAt(b - 1)){
                str.append(text1.charAt(a - 1));
                a--;
                b--;
            }
            else if(dp[a - 1][b] > dp[a][b - 1]) {
                a = a - 1;
            }
            else {
                b = b - 1;
            }
        }
        return str.reverse().toString();
    }

    public int findLongest(int[][] dp, String text1, String text2, int a, int b) {
        if(a < 0 || b < 0) {
            return 0;
        }
        if(dp[a][b] != -1) {
            return dp[a][b];
        }
        int match = 0;
        if(text1.charAt(a) == text2.charAt(b)) {
            match += (1 + findLongest(dp, text1, text2, a - 1, b - 1));
        }
        else {
            match += Math.max(findLongest(dp, text1, text2, a - 1, b),
                    findLongest(dp, text1, text2, a, b - 1));
        }
        dp[a][b] = match;
        return match;
    }
}
