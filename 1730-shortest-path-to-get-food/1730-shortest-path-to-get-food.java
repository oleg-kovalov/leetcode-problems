class Solution {
    public int getFood(char[][] grid) {
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        boolean[][] visited =  new boolean[grid.length][grid[0].length];

        LinkedList<int[]> cells = new LinkedList<>();
        for (int row =0; row < grid.length; row++)
        {
            if (cells.size() > 0 ) break;
            for (int col=0; col < grid[0].length; col++)
            {
                if (grid[row][col] == '*')
                {
                    cells.offer(new int[]{row, col});
                    visited[row][col] = true;
                    break;
                }
            }
        }

        int steps = -1;
        while (cells.size() > 0)
        {
            steps += 1;
            int size = cells.size();
            for (int i=0; i<size; i++)
            {
                int[] curr = cells.poll();
                int row = curr[0];
                int col = curr[1];

                if (grid[row][col] == '#') return steps;

                for (int[] direction: directions)
                {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (0 <= newRow && newRow < grid.length 
                        && 0 <= newCol && newCol < grid[0].length
                        && grid[newRow][newCol] != 'X'
                        && !visited[newRow][newCol])
                        {
                            cells.offer(new int[] {newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                }

            }
            
        }

        return -1;
        

    }
}