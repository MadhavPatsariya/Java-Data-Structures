package SlidingWindow;

import java.util.*;

public class TopK {
    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] arr = {1,1,1,2,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topK.topKFrequent(arr, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentFreq = frequencyMap.getOrDefault(nums[i], 0);
            frequencyMap.put(nums[i], currentFreq + 1);
        }
        int maxFrequency = 0;
        for (int val : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, val);
        }

        ArrayList<Integer>[] bucket = new ArrayList[maxFrequency];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (bucket[value - 1] == null) {
                bucket[value - 1] = new ArrayList<>();
            }
            bucket[value - 1].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxFrequency - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                k = k - bucket[i].size();
            }
            if (k <= 0) {
                break;
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
