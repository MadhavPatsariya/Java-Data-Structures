package SlidingWindow;

public class CharacterReplacement {
    public static void main(String[] args) {
        CharacterReplacement replacement = new CharacterReplacement();
        int freq = replacement.characterReplacement("ABCAB", 2);
        System.out.println("Freq: " + freq);
    }

    public int characterReplacement(String s, int k) {
        int count = 0;
        int prev = 0;
        int max = 0;
        int i = 1;
        int start = 0;
        while(i < s.length()) {
            if(s.charAt(i) != s.charAt(prev)) {
                count++;
                prev = i - 1;
            }
            if(count > k) {
                count = 0;
                max = Math.max(max, i - start);
                start = prev;
            }
            i++;
        }
        return max;
    }
}
