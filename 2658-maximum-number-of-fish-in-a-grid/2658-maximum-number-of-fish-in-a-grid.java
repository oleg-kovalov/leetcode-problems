class Solution {
    public int findMaxFish(int[][] grid) {

        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};

        boolean[][] seen = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[0].length; col++)
            {
                int start = grid[row][col];
                if (start == 0 || seen[row][col]) continue;

                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {row,col});
                seen[row][col] = true;
                
                int fish = start;
                
                while (queue.size() > 0)
                {
                    int[] cell = queue.poll();

                    for (int[] dir: dirs)
                    {
                        int newRow = cell[0] + dir[0];
                        int newCol = cell[1] + dir[1];

                        if (0 <= newRow && newRow < grid.length 
                            && 0 <= newCol && newCol < grid[0].length
                            && grid[newRow][newCol] > 0
                            && !seen[newRow][newCol])
                        {
                            queue.offer(new int[] {newRow, newCol});
                            seen[newRow][newCol] = true;
                            fish += grid[newRow][newCol];
                        }
                    }
                }

                result = Math.max(result, fish);
            }
        }

        return result;

    }
}