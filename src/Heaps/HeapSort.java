package Heaps;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] arr = {951, 436, 533, 727, 988, 487, 987, 196, 977, 746, 870};
        sort.heapSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {
        int[] data = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            upHeap(i, data, arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = remove(data, arr.length - i - 1);
        }
    }

    public void upHeap(int index, int[] data, int value) {
        int parent = (index - 1)/ 2;
        data[index] = value;
        while(parent >= 0 && data[index] < data[parent]) {
            swap(data, parent, index);
            index = parent;
            parent = (index - 1)/ 2;
        }
    }

    public void swap(int[] arr, int first, int second) {
        int t = arr[first];
        arr[first] = arr[second];
        arr[second] = t;
    }

    public int remove(int[] arr, int last) {
        int first = 0;
        int removed = arr[first];
        swap(arr, last, first);
        int index = first;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        while(left <= last - 1) {
            int smallest = index;
            if(left <= last - 1 && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if(right <= last - 1 && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if(smallest != index) {
                swap(arr, index, smallest);
                index = smallest;
                left = 2 * index + 1;
                right = 2 * index + 2;
            } else {
                break;
            }
        }
        return removed;
    }
}
