package Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {8, 2, 10, 1, 9, 7, 2, 6, 4, 9}, wt = {10, 1, 7, 7, 5, 1, 8, 6, 8, 7};
        int capacity = 21;
        System.out.println(fractionalKnapsack(val, wt, capacity));
    }

    static double fractionalKnapsack(int[] values, int[] weights, int W) {
        Items[] items = new Items[values.length];
        for(int i = 0; i < values.length; i++) {
            items[i] = new Items(weights[i], values[i]);
        }
        Arrays.sort(items, (a, b) -> (a.wt*b.value)-(a.value*b.wt));
        double total = 0;
        for(Items item: items) {
            if(W >= item.wt) {
                total += item.value;
                W -= item.wt;
            }
            else {
                total += item.unit * W;
                break;
            }
        }
        return total;
    }
}

class Items {
    int wt;
    int value;
    double unit;
    public Items (int _wt, int _value) {
        this.wt = _wt;
        this.value = _value;
        unit = (((double) value) / ((double) wt));
    }
}