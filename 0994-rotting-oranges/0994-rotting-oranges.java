class Solution {

    public int orangesRotting(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1},{0,-1}};
        
        int freshOranges = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                int value = grid[row][col];
                if (value == 1) freshOranges += 1;
                if (value == 2) queue.offer(new int[] {row, col});
            }
        }
        
        int time=0;
        int size = queue.size();
        while(queue.size() > 0)
        {
            int[] cell = queue.pop();
            
            for (int[] dir: dirs)
            {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                
                if (0 <= newRow && newRow < rows
                && 0 <= newCol && newCol < cols
                && grid[newRow][newCol] == 1)
                {
                    queue.offer(new int[] {newRow, newCol});
                    freshOranges -= 1;
                    grid[newRow][newCol] = 2;
                }
            }

            size -= 1;
            if (size == 0 && queue.size() > 0) {
                time +=1;
                size = queue.size();
            }
        }

        if (freshOranges > 0) return -1;
        return time;

    }
}