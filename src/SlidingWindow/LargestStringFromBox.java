package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LargestStringFromBox {
    public static void main(String[] args) {
        System.out.println(answerStringOptimised("nananand", 2));
    }

    public static String answerString(String word, int numFriends) {
        TreeSet<String> result = new TreeSet<>();
        int len = word.length();
        for(int i = 0; i < len; i++) {
            int j = i + 1;
            int currentMax = i + len - numFriends + 1;
            while(j < len + 1 && j < currentMax + 1 ) {
                result.add(word.substring(i, j));
                j++;
            }
        }
        return result.last();
    }

    public static String answerStringOptimised(String word, int numFriends) {
        TreeSet<String> result = new TreeSet<>();
        int len = word.length();
        if (numFriends == 1) {
            return word;
        }
        char max = 'a';
        for (int i = 0; i < len; i++) {
            char current = word.charAt(i);
            if (current >= max) {
                max = current;
            }
        }
        List<Integer> allOccurrences = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char current = word.charAt(i);
            if (current == max) {
                allOccurrences.add(i);
            }
        }
        for(int index : allOccurrences) {
            int currentMax = index + len - numFriends + 1;
            int j = index + 1;
            while (j < len + 1 && j < currentMax + 1) {
                result.add(word.substring(index, j));
                j++;
            }
        }
        return result.last();
    }
}
