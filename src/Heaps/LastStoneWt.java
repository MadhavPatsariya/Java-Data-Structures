package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWt {
    public static void main(String[] args) {
        LastStoneWt lastStoneWt = new LastStoneWt();
        int[] stones = {2,3,6,2,4};
        System.out.println("Last Stone Wt: " + lastStoneWt.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        int result = 0;
        while(!pq.isEmpty()) {
            int size = pq.size();
            if(size > 1) {
                int first = pq.poll();
                int second = pq.poll();
                if(first != second) {
                    pq.offer(Math.abs(first - second));
                }
            }
            else{
                result = pq.poll();
            }
        }
        return result;
    }
}
