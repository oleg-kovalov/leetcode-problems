class Solution {
    public int largestIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] bordersGrid = new int[grid.length][grid[0].length];

        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1,0}};

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[0].length; col++)
            {
                if (visited[row][col] || grid[row][col] == 0) continue;

                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {row, col});
                visited[row][col] = true;
                
                int square = 1;
                Set<Integer> border = new HashSet<>();
                
                while (queue.size() > 0)
                {
                    int[] curr = queue.poll();
                    

                    for (int[] direction: directions)
                    {
                        int newRow = curr[0] + direction[0];
                        int newCol = curr[1] + direction[1];

                        if (0 <= newRow && newRow < grid.length 
                            && 0 <= newCol && newCol < grid[0].length
                            && !visited[newRow][newCol])
                        {
                            if (grid[newRow][newCol] == 0)
                            {
                                border.add(newRow * grid[0].length + newCol);
                            } else {
                                queue.offer(new int[] {newRow, newCol});
                                visited[newRow][newCol] = true;
                                square += 1;
                            }
                        }
                    }
                }

                for (int cell: border)
                {
                    int newRow = cell / grid[0].length;
                    int newCol = cell % grid[0].length;
                    bordersGrid[newRow][newCol] += square;
                }
            }
        }

        int result = -1;
        for (int row=0; row < bordersGrid.length; row++)
        {
            for (int col=0; col < bordersGrid[0].length; col++)
            {
                result = Math.max(result, bordersGrid[row][col]);
            }
        }

        if (result == 0) {
            // there are no borders so either all cells are land or all are water
            return grid[0][0] == 0 ? 1 : grid.length * grid[0].length;
        }

        
        return result + 1;

    }
}