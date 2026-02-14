package DP;

public class MaximumSumNonAdjacent {
    final int MOD = 1_000_000_007;
    public static void main(String[] args) {
            
    }

    public int maximumSumSubsequence(int[] arr, int[][] queries) {
        int max = 0;
        for (int[] query : queries) {
            arr[query[0]] = query[1];
            int prev = Math.max(0, arr[0]);
            int neg = 0;
            for (int i = 1; i < arr.length; i++) {
                int curr = Math.max(arr[i] + neg, prev);
                neg = prev;
                prev = curr;
            }
            max = ( max + prev ) % MOD;
        }
        return max;
    }
}
