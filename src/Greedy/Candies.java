package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        int[] candies = {1,2,3,4,5,6,7,8,9,10};
        int N = 10;
        int K = 1;
        ArrayList<Integer> result = candyStore(candies, N, K);
        System.out.println(result);
    }

    static ArrayList<Integer> candyStore(int[] candies, int N, int K) {
        // code here
        Arrays.sort(candies);
        int minimum = 0;
        int maximum = 0;
        int count = 0;
        for(int candy : candies) {
            if(( count * K + count ) >= N) {
                break;
            }
            minimum += candy;
            count++;
        }
        for(int i = N - 1; i >= 0; i--) {
            if(count == 0) {
                break;
            }
            count--;
            maximum += candies[i];
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(minimum);
        result.add(maximum);
        return result;
    }
}
