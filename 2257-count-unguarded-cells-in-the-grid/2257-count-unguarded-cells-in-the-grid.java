class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] wall : walls)
        {
            grid[wall[0]][wall[1]] = 3;
        }

        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] guard: guards)
        {
            int row = guard[0];
            int col = guard[1];
            grid[row][col] = 2;
            for (int[] direction: directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                while (0 <= newRow && newRow < m && 0 <= newCol && newCol < n
                        && grid[newRow][newCol] <= 1)
                {
                    //not guard or wall
                    grid[newRow][newCol] = 1;   

                    newRow += direction[0];
                    newCol += direction[1];
                }
            }
        }

        int count = 0;
        for (int row=0; row < m; row++)
        {
            for (int col=0; col < n; col++)
            {
                if (grid[row][col] == 0) count += 1;

            }
        }

        return count;
    }
}