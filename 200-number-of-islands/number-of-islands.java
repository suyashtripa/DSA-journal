class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {   // land found
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        // boundary + water check
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // mark current land as visited
        grid[row][col] = '0';

        // explore all 4 directions
        dfs(grid, row + 1, col); // down
        dfs(grid, row - 1, col); // up
        dfs(grid, row, col + 1); // right
        dfs(grid, row, col - 1); // left
    }
}

        
    