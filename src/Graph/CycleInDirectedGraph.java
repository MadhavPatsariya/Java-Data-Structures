package Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {
    static List<Integer> partOfCycle;
    static List<List<Integer>> allCycles;
    public static void main(String[] args) {
        CycleInDirectedGraph cycle = new CycleInDirectedGraph();
        partOfCycle = new ArrayList<>();
        allCycles = new ArrayList<>();
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {4, 3}, {3, 0}};
        int V = 6;
        System.out.println("Is Cycle: " + cycle.isCyclic(V, edges));
        System.out.println("Nodes part of Cycle: ");
        System.out.println(allCycles);
    }

    public boolean isCyclic(int V, int[][] edges) {
        boolean[] pathVisited = new boolean[V];
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsTraversal(i, adjacencyList, pathVisited, visited);
            }
        }
        return false;
    }

    public void dfsTraversal(int current, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] pathVisited, boolean[] visited) {
        if(visited[current] && pathVisited[current]) {
            allCycles.add(new ArrayList<>(partOfCycle));
            return;
        }
        if(visited[current] && !pathVisited[current]) {
            partOfCycle.clear();
            return;
        }
        visited[current] = true;
        pathVisited[current] = true;
        partOfCycle.add(current);
        for(int neighbour : adjacencyList.get(current)) {
            dfsTraversal(neighbour, adjacencyList, pathVisited, visited);
        }
        pathVisited[current] = false;
//        return false;
    }
}
