class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};


        boolean[][] reachPacific = new boolean[rows][cols];
        
        LinkedList<int[]> queue = new LinkedList<>(); // [row,col,height]
        for (int row=0; row<rows; row++)
        {
            queue.offer(new int[] {row, 0, heights[row][0]});
            reachPacific[row][0] = true;
        } 
        for (int col=1; col<cols; col++)
        {
            queue.offer(new int[] {0, col, heights[0][col]});
            reachPacific[0][col] = true;
        }

        while (queue.size() > 0)
        {
            int[] cell = queue.poll();

            for (int[] dir: dirs)
            {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                
                if (0<= newRow && newRow < rows
                    && 0<= newCol && newCol < cols
                    && !reachPacific[newRow][newCol]
                    && heights[newRow][newCol] >= cell[2])
                {
                    reachPacific[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol, heights[newRow][newCol]});
                }
            }
        }

        boolean[][] reachAtlantic = new boolean[rows][cols];
        for (int row=0; row<rows; row++)
        {
            queue.offer(new int[] {row, cols-1, heights[row][cols-1]});
            reachAtlantic[row][cols-1] = true;
        }
        for (int col=0; col<cols-1; col++)
        {
            queue.offer(new int[] {rows-1, col, heights[rows-1][col]});
            reachAtlantic[rows-1][col] = true;
        }

        while (queue.size() > 0)
        {
            int[] cell = queue.poll();

            for (int[] dir: dirs)
            {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if (0<= newRow && newRow < rows
                    && 0<= newCol && newCol < cols
                    && !reachAtlantic[newRow][newCol]
                    && heights[newRow][newCol] >= cell[2])
                {
                    reachAtlantic[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol, heights[newRow][newCol]});
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (reachPacific[row][col] && reachAtlantic[row][col])
                {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(row); 
                    cell.add(col);
                    
                    result.add(cell);
                }
            }
        }

        return result;

    }

}