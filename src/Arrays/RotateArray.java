package Arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1000000000,1000000000};
        System.out.println(Arrays.toString(array));
        System.out.println(getMaxLen(array));
        System.out.println(minUsingKadane(array));
    }

    public static void rotateArray(int[] array) {
        int last = array[array.length - 1];
        for(int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;
    }

    public static int minUsingKadane(int[] array) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
            if(sum > array[i]) {
                sum = array[i];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public static int getMaxLen(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            long product = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if(product > 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
            if(product > 0) {
                max = Math.max(max, nums.length - i);
            }
        }
        return max;
    }

}
