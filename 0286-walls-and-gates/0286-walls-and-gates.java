class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        final int WALL = -1;
        final int GATE = 0;
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; 

        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (rooms[row][col] == GATE)
                {
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {row, col, 1});

                    boolean[][] visited = new boolean[rows][cols];

                    while (queue.size() > 0)
                    {
                        int[] cell = queue.poll();
                        int dist = cell[2];

                        for (int[] dir: dirs)
                        {
                            int newRow = cell[0] + dir[0];
                            int newCol = cell[1] + dir[1];

                            if (0 <= newRow && newRow < rows
                                && 0 <= newCol && newCol < cols
                                && rooms[newRow][newCol] > 0 
                                && !visited[newRow][newCol])
                            {
                                visited[newRow][newCol] = true;
                                rooms[newRow][newCol] = Math.min(dist, rooms[newRow][newCol]);
                                queue.offer(new int[] {newRow, newCol, dist + 1});
                            }
                        }
                    }                    
                }
            }
        }

    }
}