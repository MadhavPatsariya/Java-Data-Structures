package SlidingWindow;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] number = {1,2};
        for(int i = 0; i < 7; i++){
            rotate(number, i);
            System.out.println("for i: " + i + " ; Rotated Array: " + Arrays.toString(number));
            number = new int[]{1, 2};
        }
    }

    public static void rotate(int[] nums, int k) {
        int arr[] = new int[k];
        int len = nums.length;
        k = k % (len);
        for(int i = k; i > 0; i--) {
            arr[k-i] = nums[len - i];
        }
        for(int i = len - k - 1; i >=0; i--) {
            nums[i + k] = nums[i];
        }
        for(int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
    }
}
