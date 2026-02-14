package Graph;

import java.util.Arrays;

public class MinCostConnectedPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        connectPoints(points);
    }

    public static void connectPoints(int[][] points) {
        int V = points.length;
        int[][] edges = new int[V * (V - 1)][3];
        int edgeIndex = 0;
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i != j) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges[edgeIndex++] = new int[] {i, j, distance};
                }
            }
        }
        System.out.println(Arrays.deepToString(edges));
    }
}
