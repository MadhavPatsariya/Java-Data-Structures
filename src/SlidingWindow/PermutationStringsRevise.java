package SlidingWindow;

public class PermutationStringsRevise {
    public static void main(String[] args) {
        PermutationStringsRevise str = new PermutationStringsRevise();
        System.out.println(str.checkInclusion("ab", "eidbaooo"));
    }

    int[] s1Freq = new int[26];
    int[] s2Freq = new int[26];
    public boolean checkInclusion(String s1, String s2) {
        int prev = 0;
        for(int i = 0; i < s1.length(); i++) {
            char current = s1.charAt(i);
            s1Freq[current - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);
            s2Freq[current - 'a']--;
            if((i - prev + 1) == s1.length()) {
                if(checkArray()){
                    return true;
                }
                else{
                    s2Freq[s2.charAt(prev) - 'a']++;
                    prev++;
                }
            }
        }
        return false;
    }

    public boolean checkArray() {
        for(int i = 0; i < 26; i++) {
            if(s2Freq[i] != s1Freq[i]) {
                return false;
            }
        }
        return true;
    }
}
