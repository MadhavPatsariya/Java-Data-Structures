package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPermutations {
    List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        FindAllPermutations allPermutations = new FindAllPermutations();
        int[] arr = {1, 1, 2};
        System.out.println(allPermutations.permutations(arr));
    }

    public List<List<Integer>> permutations(int[] arr) {
        ArrayList<Integer> current = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        permutation(arr, set, current);
        return list;
    }

    public void permutation(int[] arr, Set<Integer> set, List<Integer> list) {
        if(list.size() == arr.length) {
            this.list.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!set.contains(i)) {
                list.add(arr[i]);
                set.add(i);
                permutation(arr, set, list);
                list.removeLast();
                set.remove(i);
            }
        }
    }
}
