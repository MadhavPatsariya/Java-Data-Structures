package String;
import java.util.*;

public class ReorganiseString {
    public static void main(String[] args) {
        ReorganiseString reorganiseString = new ReorganiseString();
        System.out.println(reorganiseString.reorganizeString("spfff"));
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        if (maxFreq > s.length() / 2 + 1)
            return "";
        queue.addAll(map.keySet());
        char[] str = new char[s.length()];
        int index = 0;
        while (!map.isEmpty()) {
            char currentChar = queue.poll();
            int count = map.get(currentChar);
            for(int i = 0; i < count; i++) {
                if(index >= s.length()) {
                    index = 1;
                }
                str[index] = currentChar;
                index = index + 2;
            }
            map.remove(currentChar);
        }
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i - 1])
                return "";
        }
        return new String(str);
    }
}
