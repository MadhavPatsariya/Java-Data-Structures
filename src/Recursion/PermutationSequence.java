package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(2, 1));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>(n);
        k = k - 1;
        int factorial = 1;
        for(int i = 1; i < n; i++) {
            factorial *= i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder str = new StringBuilder();
        while(true) {
            str.append(numbers.get(k / factorial));
            numbers.remove(k / factorial);
            if(numbers.size() == 1) {
                str.append(numbers.get(0));
                break;
            }
            k = k % factorial;
            factorial = factorial / numbers.size();
        }
        return str.toString();
    }
}
