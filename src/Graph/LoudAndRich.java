package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoudAndRich {
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        System.out.println(loudAndRich(richer, quiet));
    }

    public static  List<LevelIndex> loudAndRich(int[][] richer, int[] quiet) {
        int V = quiet.length;
        int[] indegree = new int[V];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] edge : richer) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }
        for(int i = 0; i < V; i++) {
            for(int node : list.get(i)) {
                indegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<LevelIndex> sorted = new ArrayList<>();
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                sorted.add(new LevelIndex(current, level));
                for(int neighbour : list.get(current)) {
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        //Now we have a sorted order;
        return sorted;
    }
}

class LevelIndex {
    int node;
    int level;
    public LevelIndex(int node, int level) {
        this.node = node;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Node: " + this.node + " @Level: " + this.level;
    }
}
