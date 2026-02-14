package SlidingWindow;

import java.util.Arrays;

public class KokoEatsBananas {
    public static void main(String[] args) {
        KokoEatsBananas bananas = new KokoEatsBananas();
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println("Min: " + bananas.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int x : piles) {
            max = Math.max(x, max);
        }
        int min = 1;
        int result = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = (max - min) / 2 + min;
            int minCount = count(piles, mid);
            if(minCount > 0 && minCount <= h) {
                result = Math.min(mid, result);
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return result;
    }

    public int count(int[] piles, int min) {
        int total = 0;
        for (int pile : piles) {
            if (pile <= min) {
                total += 1;
            } else {
                total += (int) Math.ceil((double) pile / min);
            }
        }
        return total;
    }
}
