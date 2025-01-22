class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        
        int[][] grid = new int[isWater.length][isWater[0].length];


        LinkedList<int[]> cells = new LinkedList<>();
        for (int row=0; row < grid.length; row++)
        {
            Arrays.fill(grid[row], -1);
            for (int col=0; col < grid[0].length; col++)
            {
                if (isWater[row][col] == 1)
                {
                    grid[row][col] = 0;
                    cells.offer(new int[] {row, col});
                    visited[row][col] = true;
                }
            }
        }

        while (cells.size() > 0)
        {
            int[] curr = cells.poll();
            int row = curr[0];
            int col = curr[1];
            int heigth = grid[row][col];
            
            for (int[] dir : dirs)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (0 <= newRow && newRow < grid.length 
                && 0 <= newCol && newCol < grid[0].length
                && ! visited[newRow][newCol])
                {
                    grid[newRow][newCol] = heigth + 1;
                    cells.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return grid;





    }
}