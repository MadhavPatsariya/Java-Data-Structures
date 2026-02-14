package Graph;

import java.util.Arrays;

public class FloydMarshall {
    public static void main(String[] args) {
        FloydMarshall floydMarshall = new FloydMarshall();
        int[][] matrix = {{0, 8, 7, -3},
                        {1, 0 ,- 1 ,6},
                        {9 ,5 ,0 ,5},
                        {100000000, 100000000, 100000000, 0 }};
        floydMarshall.floydWarshall(matrix);
        System.out.println(Arrays.deepToString(matrix));
    };

    public void floydWarshall(int[][] dist) {
        int max = 10_00_00_000;
        for(int via = 0; via < dist.length; via++) {
            for(int i = 0; i < dist.length; i++) {
                for(int j = 0; j < dist[0].length; j++) {
                    if(dist[i][j] == max && (dist[i][via] == max || dist[via][j] == max)) {
                        continue;
                    }
                    else {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }
}
