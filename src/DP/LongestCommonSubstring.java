package DP;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println("LCS: " + lcs.longestCommonSubstring("abgdcde", "bgdke"));
    }

    public String longestCommonSubstring(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        int endIndex = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = (1 + dp[i - 1][j - 1]);
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i; // store the ending index in text1
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        if(max > 0) {
            return text1.substring(endIndex - max, endIndex);
        }
        else {
            return "";
        }
    }
}
