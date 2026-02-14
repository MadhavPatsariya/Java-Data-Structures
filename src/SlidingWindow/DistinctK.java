package SlidingWindow;

import java.util.HashMap;

public class DistinctK {
    public static void main(String[] args) {
        int[] array = {1,2,1,2,3};
        int k = 2;
        System.out.println(subArraysWithKDistinct(array, k));
    }

    public static int subArraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prev = 0, count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(map.isEmpty()) {
                map.put(nums[i], 1);
            }
            if(!map.containsKey(nums[i + 1])) {
                while(map.size() == k) {
                    count++;
                    int prevFreq = map.get(nums[prev]);
                    if(prevFreq > 1) {
                        map.put(nums[prev], prevFreq - 1);
                    }
                    else{
                        map.remove(nums[prev]);
                    }
                    prev++;
                }
                map.put(nums[i + 1], 1);
            }
            else{
                int prevFreq = map.get(nums[i + 1]);
                map.put(nums[i + 1], prevFreq + 1);
            }
        }
        return count;
    }
}
