package SlidingWindow;

public class CountSubArrays {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,3};
        System.out.println("Maximum sun - Fixed : " + countSubArray(array, 3));
    }

    public static int countSubArray(int[] array, int k) {
        int sum = 0;
        int count = 0;
        int prev = 0;
        for (int j : array) {
            sum += j;
            while (sum > k) {
                sum -= array[prev];
                prev++;
            }
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}
