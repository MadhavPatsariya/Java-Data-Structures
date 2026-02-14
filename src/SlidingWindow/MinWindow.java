package SlidingWindow;

import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {
        MinWindow window = new MinWindow();
        String result = window.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("Result: " + result);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            int freq = hashMap.getOrDefault(c, 0);
            hashMap.put(c, freq + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();
        int i = 0;
        int count = 0;
        int start = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        while(i < s.length()) {
            char currentChar = s.charAt(i);
            if(hashMap.containsKey(currentChar)) {
                int freq = windowMap.getOrDefault(currentChar, 0);
                windowMap.put(currentChar, freq + 1);
                if(windowMap.get(currentChar) == hashMap.get(currentChar)){
                    count++;
                }
            }
            while(count == hashMap.size()) {
                if(min > i - start + 1) {
                    min = i - start + 1;
                    result = s.substring(start, i + 1);
                }
                char startChar = s.charAt(start);
                if(hashMap.containsKey(startChar)) {
                    int freq = windowMap.get(startChar);
                    windowMap.put(startChar, freq - 1);
                    if(windowMap.get(startChar) < hashMap.get(startChar)){
                        count--;
                    }
                }
                start++;
            }
            i++;
        }
        return result;
    }
}
