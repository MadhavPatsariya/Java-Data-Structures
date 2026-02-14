package Heaps;

import java.util.ArrayList;
import java.util.Arrays;

public class KthClosestToOrigin {
    ArrayList<Pair> minHeap;
    int overAllK;
    public static void main(String[] args) {
        KthClosestToOrigin origin = new KthClosestToOrigin();
        int[][] points = {{0,2},{2,2}, {2,0}};
        int k = 1;
        int[][] result = origin.kClosest(points, 2);
        System.out.println("Result: " + Arrays.deepToString(result));
    }

    public int[][] kClosest(int[][] points, int k) {
        minHeap = new ArrayList<>();
        overAllK = k;
        for (int[] point : points) {
            insertion(new Pair(point[0], point[1]));
        }
        while(minHeap.size() > overAllK) {
            removal();
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            Pair current = minHeap.get(i);
            result[i][0] = current.x;
            result[i][1] = current.y;
        }
        return  result;
    }

    public void insertion(Pair value) {
        minHeap.add(value);
        upHeap(minHeap.size() - 1);
    }

    public void upHeap(int current) {
        int parent = (current - 1) / 2;
        if(parent < 0) {
            return;
        }
        if(minHeap.get(current).distance > minHeap.get(parent).distance) {
            swap(current, parent);
            upHeap(parent);
        }
    }

    public void removal() {
        int first = 0;
        int last = minHeap.size() - 1;
        swap(first, last);
        minHeap.removeLast();
        downHeap(first);
    }

    public void downHeap(int first) {
        if(first >= minHeap.size()) {
            return;
        }
        int left = 2 * first + 1;
        int right = 2 * first + 2;
        int smallest = first;

        if(left < minHeap.size() && minHeap.get(left).distance > minHeap.get(smallest).distance) {
            smallest = left;
        }

        if(right < minHeap.size() && minHeap.get(right).distance > minHeap.get(smallest).distance) {
            smallest = right;
        }

        if(smallest != first) {
            swap(smallest, first);
            downHeap(smallest);
        }
    }

    public void swap(int f, int s) {
        Pair t = minHeap.get(s);
        minHeap.set(s, minHeap.get(f));
        minHeap.set(f, t);
    }
}

class Pair{
    int x;
    int y;
    double distance;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(x*x + y*y);
    }
}

