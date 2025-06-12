class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        final int WALL = -1;
        final int GATE = 0;
        final int INF = Integer.MAX_VALUE;
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}}; 

        Queue<int[]> queue = new LinkedList<>();
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (rooms[row][col] == GATE)
                    queue.offer(new int[] {row, col});
            }
        }

        int distance = 0;
        int size = queue.size();
        while (queue.size() > 0)
        {
            int[] cell = queue.poll();

            for (int[] dir: dirs)
            {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if (0 <= newRow && newRow < rows
                    && 0 <= newCol && newCol < cols
                    && rooms[newRow][newCol] == INF)
                {
                    rooms[newRow][newCol] = distance + 1;
                    queue.offer(new int[] {newRow, newCol});    
                }
            }

            size -= 1;
            if (size == 0)
            {
                size = queue.size();
                distance += 1;
            }
        }

    }
}