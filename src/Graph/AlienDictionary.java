package Graph;
import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(findOrder(words));
    }

    public static String findOrder(String[] words) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                set.add(ch);
            }
        }

        boolean[] seen = new boolean[26];
        for (char ch : set) {
            seen[ch - 'a'] = true;
        }
        int[] indegree = new int[26];
        for(int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int fi = 0;
            int si = 0;
            if(first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            while(fi < first.length() && si < second.length()) {
                int firstCh = first.charAt(fi) - 'a';
                int secondCh = second.charAt(si) - 'a';
                if(firstCh != secondCh) {
                    map.computeIfAbsent(firstCh, k -> new ArrayList<>()).add(secondCh);
                    break;
                }
                fi++;
                si++;
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> list = entry.getValue();
            for(int x : list) {
                indegree[x]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            if(seen[i] && indegree[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                char ch = (char) ((char) current + 'a');
                str.append(ch);
                if(!map.containsKey(current)) continue;
                for(int related : map.get(current)) {
                    indegree[related]--;
                    if (seen[related] && indegree[related] == 0) {
                        queue.offer(related);
                    }
                }
            }
        }
        if(set.size() != str.length()) {
            return "";
        }
        else return str.toString();
    }
}
