package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ProductLessThanK {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubArrayProductLessThanK(nums, k));
        System.out.println(list);
    }

//    public static int numSubArrayProductLessThanK(int[] nums, int k) {
//        int output = 0;
//        for(int i = 0; i < nums.length; i++) {
//            int product = 1;
//            List<Integer> current = new ArrayList<>();
//            for(int j = i; j < nums.length; j++) {
//                product *= nums[j];
//                if(product < k) {
//                    current.add(nums[j]);
//                    list.add(new ArrayList<>(current));
//                    output++;
//                }
//                else{
//                    break;
//                }
//            }
//        }
//        return output;
//    }

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int output = 0;
        int start = 0, current = 0;
        int product = 1;
        List<Integer> currentList = new ArrayList<>();
        while(current < nums.length) {
            product *= nums[current];
            currentList.add(nums[current]);
            while(product >= k && start <= current) {
                product /= nums[start];
                currentList.remove(Integer.valueOf(nums[start]));
                start++;
            }
            list.add(new ArrayList<>(currentList));
            output += (current - start + 1);
            current++;
        }
        return output;
    }
}
