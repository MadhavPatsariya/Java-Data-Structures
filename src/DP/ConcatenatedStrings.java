package DP;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedStrings {
    public static void main(String[] args) {
        ConcatenatedStrings concatenatedStrings = new ConcatenatedStrings();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(concatenatedStrings.findAllConcatenatedWordsInADict(words));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int prevStrLen = words[i].length();
                int currStrLen = words[j].length();
                if (prevStrLen != currStrLen) {
                    if (prevStrLen > currStrLen) {
                        boolean isLCS = findLCS(words[i], words[j]);
                        if(isLCS) {
                            count[i]++;
                        }
                    } else {
                        boolean isLCS = findLCS(words[j], words[i]);
                        if(isLCS) {
                            count[j]++;
                        }
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(count[i] > 1) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public boolean findLCS(String s, String t) {
        String lcs = getCommonString(s, t);
        if(s.equals("cats")) {
            System.out.println("lcs for cats: " + lcs);
        }
        return lcs.equals(t);
    }

    public String getCommonString(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        int endIndex = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = (1 + dp[i - 1][j - 1]);
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i; // store the ending index in text1
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if (max > 0) {
            return text1.substring(endIndex - max, endIndex);
        } else {
            return "";
        }
    }
}
