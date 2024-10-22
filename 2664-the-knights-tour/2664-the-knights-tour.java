class Solution {
    int cellsToVisit;
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        cellsToVisit = m * n;
        int[][] grid = new int[m][n];
        for (int i=0; i<m; i++)
        {
            Arrays.fill(grid[i], -1);
        }

        backtrack(grid, r, c, 0);

        return grid;        
    }

    private boolean backtrack(int[][] grid, int row, int col, int order) 
    {
        if (0 > row || row >= grid.length){
            return false;
        }
        if (0 > col || col >= grid[0].length)
        {
            return false;
        }
        
        if (grid[row][col] != -1)
        {
            return false;
        }

        grid[row][col] = order;
        if (order + 1 == grid.length * grid[0].length)
        {
            return true;
        }

        int[][] moves = new int[][] {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1,-2}
        };

        for (int[] move: moves)
        {
            boolean result = backtrack(grid, row + move[0], col + move[1], order+1);
            if (result) {
                return true;
            }
        }

        grid[row][col] = -1;

        return false;

    }
}