package SlidingWindow;

public class SumSubArray {
    public static void main(String[] args) {
        int[] array = {2,1,5,1,3,2};
        int[] longest = {2,1,5,1,3};
        System.out.println("Maximum sun - Fixed : " + maximumSubArraySum(array, 3));
        System.out.println("Longest - Variable: " + longestSubArray(longest, 7));
    }

    public static int maximumSubArraySum(int[] array, int size) {
        int max = 0;
        int prev = 0;
        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(i - prev + 1 > size) {
                currentSum -= array[prev];
                prev++;
            }
            max = Math.max(currentSum, max);
        }
        return max;
    }

    public static int longestSubArray(int[] array, int target) {
        int size = 0;
        int sum = 0;
        int prev = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            while(sum > target) {
                sum -= array[prev];
                prev++;
            }
            size = Math.max(size, i - prev + 1);
        }
        return size;
    }
}
