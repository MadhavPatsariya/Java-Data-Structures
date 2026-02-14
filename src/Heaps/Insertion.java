package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        boolean wantsToEnter = true;
        int[] list = {19, 20, 1, 2, 25, 13, 5};
       /* while(wantsToEnter) {
            System.out.println("Do you want to enter a value: ");
            System.out.println("1: YES, 2: NO");
            int optionSelection = scanner.nextInt();
            if(optionSelection == 1) {
                System.out.println("Please enter the value you want to insert: ");
                list.add(scanner.nextInt());
            }
            else wantsToEnter = false;
        }
        System.out.println("ArrayList: " + list);*/
        int[] minHeap = new int[list.length + 1];
        int currentIdx = 1;
        for(int integer: list) {
            currentIdx = insertion(minHeap, integer, currentIdx);
        }
        System.out.println("Minimum Value You Entered: " + minHeap[1]);
        System.out.println("Complete Arr: " + Arrays.toString(minHeap));
        minHeap = removal(minHeap);
        System.out.println("After Removal of first, min number is: " + minHeap[1]);
        minHeap = removal(minHeap);
        System.out.println("After Removal of first, min number is: " + minHeap[1]);
        minHeap = removal(minHeap);
        System.out.println("After Removal of first, min number is: " + minHeap[1]);
    }

    public static int insertion(int[] arr, int value, int index) {
        int parent = index / 2;
        arr[index] = value;
        while(parent >= 0 && arr[index] < arr[parent]) {
            swap(index, parent, arr);
            index = parent;
            parent = (index - 1)/ 2;
        }
        return index + 1;
    }

    public static int[] removal(int[] arr) {
        int last = arr.length - 1;
        int first = 1;
        swap(last, first, arr);
        int left = 2 * first;
        int right = 2 * first + 1;
        while(left < last && right < last) {
            if(arr[left] < arr[right] && arr[left] < arr[first]) {
                swap(first, left, arr);
            }
            else if(arr[right] < arr[left] && arr[right] < arr[first]) {
                swap(first, right, arr);
            }
            first = left;
            left = 2 * first;
            right = 2 * first + 1;
        }
        return Arrays.copyOfRange(arr, 0, last);
    }

    public static void swap(int l, int r, int[] arr) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
