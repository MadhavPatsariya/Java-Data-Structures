package DP;

public class MinFallingPathSum {
    public static void main(String[] args) {
        MinFallingPathSum pathSum = new MinFallingPathSum();
        int[][] matrix = {{17, 82}, {1, -44}};
        System.out.println(pathSum.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for(int r = 1; r < n; r++) {
            for(int c = 0; c < n; c++) {
                int left = Integer.MAX_VALUE;
                if(c - 1 >= 0) {
                    left = matrix[r][c] + dp[r - 1][c - 1];
                }
                int current = Math.min(matrix[r][c] + dp[r - 1][c], left);
                if(c + 1 < n) {
                    current = Math.min(matrix[r][c] + dp[r - 1][c + 1], current);
                }
                dp[r][c] = current;
            }
        }
        for(int i = 0; i < n; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }
}
