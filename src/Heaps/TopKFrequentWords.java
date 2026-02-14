package Heaps;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords frequentWords = new TopKFrequentWords();
        String[] str = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(frequentWords.topKFrequent(str, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<P> queue = new PriorityQueue<P>((a, b) -> a.freq - b.freq);
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(queue.size() > k && queue.peek().freq < entry.getValue()) {
                queue.poll();
            }
            queue.add(new P(entry.getKey(), entry.getValue()));
        }
        while(queue.size() > k) {
            queue.poll();
        }
        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll().str);
        }
        return list;
    }
}

class P{
    String str;
    int freq;
    public P(String _str, int _freq) {
        this.str = _str;
        this.freq = _freq;
    }
}