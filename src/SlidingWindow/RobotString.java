package SlidingWindow;

import java.util.Stack;

public class RobotString {
    public static void main(String[] args) {
        String s = "bydizfve";
        System.out.println("Paper String: " + robotWithString(s));
    }

    public static String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        int[] freq = new int[26];
        StringBuilder p = new StringBuilder();
        char minChar = 'z';
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if(minChar > s.charAt(i)) {
                minChar = s.charAt(i);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            t.push(s.charAt(i));
            freq[s.charAt(i) - 'a']--;
            while(minChar != 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }
            while(!t.isEmpty() && t.peek() <= minChar) {
                p.append(t.pop());
            }
        }

        while(!t.isEmpty()) {
            p.append(t.pop());
        }
        return p.toString();
    }
}
