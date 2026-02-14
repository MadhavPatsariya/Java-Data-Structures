package SlidingWindow;

import java.util.HashMap;

public class PermutationStrings {
    public static void main(String[] args) {
        PermutationStrings permutationStrings = new PermutationStrings();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = permutationStrings.arrCheckInclusion(s1, s2);
        System.out.println("Result: " + result);
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int current = s1Map.getOrDefault(ch, 0);
            s1Map.put(ch, current + 1);
        }
        int windowSize = s1.length();
        int start = 0;
        int current = 0;
        int end = s2.length();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        while(current < end) {
            char c = s2.charAt(current);
            int freq = s2Map.getOrDefault(c, 0);
            s2Map.put(c, freq + 1);
            if(current - start + 1 == windowSize){
                if(s1Map.equals(s2Map)) {
                    return true;
                }
                else {
                    char firstChar = s2.charAt(start);
                    int firstCharFreq = s2Map.get(firstChar);
                    if(firstCharFreq == 1) {
                        s2Map.remove(firstChar);
                    }
                    else {
                        s2Map.put(firstChar, firstCharFreq - 1);
                    }
                    start++;
                }
            }
            current++;
        }
        return false;
    }

    public boolean arrCheckInclusion(String s1, String s2) {
        int[] charArray = new int[26];
        int windowSize = s1.length();
        for(int i = 0; i < windowSize; i++) {
            charArray[s1.charAt(i) - 'a']++;
        }

        int start = 0;
        int current = 0;
        int end = s2.length();
        while(current < end) {
            char ch = s2.charAt(current);
            charArray[ch - 'a']--;
            if(current - start + 1 == windowSize){
                if(zeroFreq(charArray)) {
                    return true;
                }
                else {
                    charArray[s2.charAt(start) - 'a']++;
                    start++;
                }
            }
            current++;
        }
        return false;
    }

    public boolean zeroFreq(int[] arr) {
        for(int i : arr) {
            if(i != 0) return false;
        }
        return true;
    }
}
