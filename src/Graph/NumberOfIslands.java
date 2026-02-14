package Graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(islands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int numberOfIslands = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, n, m, i, j, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public void dfs(char[][] grid, int n, int m, int r, int c, boolean[][] visited) {
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return;
        }
        if(visited[r][c]) {
            return;
        }
        if(grid[r][c] == '0') {
            return;
        }
        visited[r][c] = true;
        dfs(grid, n, m, r, c + 1, visited);
        dfs(grid, n, m, r, c - 1, visited);
        dfs(grid, n, m, r - 1, c - 1, visited);
        dfs(grid, n, m, r - 1, c + 1, visited);
        dfs(grid, n, m, r + 1, c - 1, visited);
        dfs(grid, n, m, r + 1, c + 1, visited);
        dfs(grid, n, m, r + 1, c, visited);
        dfs(grid, n, m, r - 1, c, visited);
    }
}
