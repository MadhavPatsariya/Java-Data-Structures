package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {{1},{2},{3}, {}};
        BiPartiteGraph partiteGraph = new BiPartiteGraph();
        System.out.println(partiteGraph.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int[] colorArray = new int[graph.length];
        Arrays.fill(colorArray, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int prevColor = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (colorArray[current] == -1) {
                    colorArray[current] = prevColor;
                    int[] neighbours = graph[current];
                    for (int neighbour : neighbours) {
                        queue.add(neighbour);
                    }
                } else {
                    if (prevColor != colorArray[current]) {
                        return false;
                    }
                }
            }
            if (prevColor == 0) {
                prevColor = 1;
            } else {
                prevColor = 0;
            }
        }
        return true;
    }
}
