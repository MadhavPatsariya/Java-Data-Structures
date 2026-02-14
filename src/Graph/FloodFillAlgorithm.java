package Graph;

import java.util.Arrays;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        FloodFillAlgorithm floodFill = new FloodFillAlgorithm();
        int[][] grid = {
                {1,1,1},
                {1,1,0},
                {1,0,1},
        };
        int[][] updatedGrid = floodFill.floodFill(grid, 1, 1, 2);
        System.out.println(Arrays.deepToString(updatedGrid));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFillUtil(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void floodFillUtil(int[][] image, int r, int c, int newColor, int old) {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }
        if(image[r][c] != old) {
            return;
        }
        image[r][c] = newColor;
        floodFillUtil(image, r + 1, c, newColor, old);
        floodFillUtil(image, r - 1, c, newColor, old);
        floodFillUtil(image, r, c + 1, newColor, old);
        floodFillUtil(image, r, c - 1, newColor, old);
    }
}
