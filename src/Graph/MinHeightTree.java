package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightTree {
    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][1];
            int v = edges[i][0];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int height = bfs(i, adjList);
            if(height < minHeight) {
                if(!result.isEmpty()) {
                    result.clear();
                    result.add(i);
                }
                else {
                    result.add(i);
                }
                minHeight = height;
            }
            else if(height == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    public int bfs(int startingNode, List<List<Integer>> adj) {
        int nodes = adj.size();
        boolean[] visited = new boolean[nodes];
        Queue<AdvanceNode> queue = new LinkedList<>();
        queue.offer(new AdvanceNode(startingNode, 0));
        visited[startingNode] = true;
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AdvanceNode currentNode = queue.poll();
                List<Integer> connected = adj.get(currentNode.data);
                height = Math.max(currentNode.height, height);
                for (int node : connected) {
                    if (!visited[node]) {
                        queue.offer(new AdvanceNode(node, currentNode.height + 1));
                        visited[node] = true;
                    }
                }
            }
        }
        return height;
    }
}

class AdvanceNode {
    int data;
    int height;
    public AdvanceNode(int data, int height) {
        this.data = data;
        this.height = height;
    }
}
