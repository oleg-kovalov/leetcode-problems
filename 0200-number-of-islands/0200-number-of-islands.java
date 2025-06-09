class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; 
                
        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (grid[row][col] != '1') continue;
                if (visited[row][col]) continue;

                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {row, col});
                visited[row][col] = true;
                count += 1;
                
                while (queue.size() > 0)
                {
                    int[] cell = queue.poll();

                    for (int[] dir: dirs)
                    {
                        int newRow = cell[0] + dir[0];
                        int newCol = cell[1] + dir[1];
                        if (0 <= newRow && newRow < rows
                            && 0 <= newCol && newCol < cols
                            && grid[newRow][newCol] == '1'
                            && !visited[newRow][newCol])
                        {
                            queue.offer(new int[] {newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}