package SlidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
//        int[] nums = {100,4,200,1,3,2};
        System.out.println("Len: " + lcs.longestConsecutiveOptimised(nums));
    }

    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        int prev = 0;
        for (int val : treeSet) {
            prev = val;
            break;
        }
        Iterator<Integer> values = treeSet.iterator();
        int count = 1;
        int max = 1;
        while(values.hasNext()) {
            int current = values.next();
            if (prev != current) {
                if (current - prev == 1) {
                    count++;
                } else {
                    count = 1;
                }
            }
            prev = current;
            max = Math.max(count, max);
        }
        return max;
    }

    public int longestConsecutiveOptimised(int[] nums) {
        int max = 1;
        HashMap<Integer, Integer> island = new HashMap<>();
        for (int current : nums) {
            if(!island.containsKey(current)) {
                int len = 1;
                int leftNeighbour = island.getOrDefault(current - 1, 0);
                int rightNeighbour = island.getOrDefault(current + 1, 0);
                len += leftNeighbour + rightNeighbour;
                if(leftNeighbour != 0) {
                    island.put(current - leftNeighbour, len);
                }
                if(rightNeighbour != 0) {
                    island.put(current + rightNeighbour, len);
                }
                island.put(current, len);
                max = Math.max(max, island.get(current));
            }
        }
        return max;
    }
}
