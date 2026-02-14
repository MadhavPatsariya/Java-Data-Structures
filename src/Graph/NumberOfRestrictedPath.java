package Graph;
import java.util.*;

public class NumberOfRestrictedPath {
    public static void main(String[] args) {
        NumberOfRestrictedPath restrictedPath = new NumberOfRestrictedPath();
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        int n = 5;
        restrictedPath.countRestrictedPaths(n, edges);
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<WtNode>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            list.get(u - 1).add(new WtNode(v - 1, wt));
            list.get(v - 1).add(new WtNode(u - 1, wt));
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.offer(n - 1);
        distance[n - 1] = 0;
        int total = 1;
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.remove();
                path.add(current);
                if(current == 0) {
                    paths.add(new ArrayList<>(path));
                    path.clear();
                }
                for(WtNode related : list.get(current)) {
                    int node = related.node;
                    int wt = related.wt;
                    if(distance[current] + wt < distance[node]) {
                        distance[node] = distance[current] + wt;
                        queue.offer(node);
                    }
                }
            }
        }
        System.out.println(paths);
        return total;
    }
}

class WtNode {
    int node;
    int wt;
    public WtNode(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}
