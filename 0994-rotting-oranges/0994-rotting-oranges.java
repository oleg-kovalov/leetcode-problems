class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        int freshCounter = 0;

        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                if (grid[row][col] == 2)
                {
                    queue.offer(new int[] {row, col});
                } else if (grid[row][col] == 1)
                {
                    freshCounter += 1;
                }
            }
        }

        if (queue.size() == 0 ) return freshCounter > 0 ? -1 : 0;

        int depth = 0;
        int depthCount = queue.size();
        while (queue.peek() != null)
        {
            final int[] orange = queue.poll();
            int row = orange[0];
            int col = orange[1];

            int[][] nCoord = new int[][]{
                {row-1, col},
                {row+1, col},
                {row, col-1},
                {row, col+1}};

            for (int coord=0; coord < nCoord.length; coord++)
            {
                int nRow = nCoord[coord][0];
                int nCol = nCoord[coord][1];
                if (0 <= nRow && nRow <= grid.length-1
                    && 0 <= nCol && nCol <= grid[row].length-1
                    && grid[nRow][nCol] == 1)
                {
                    queue.add(new int[]{nRow, nCol});
                    grid[nRow][nCol] = 2;
                    freshCounter -= 1;
                }
            }
            depthCount -= 1;
            if (depthCount == 0 && queue.size() > 0)
            {
                depth += 1;
                depthCount = queue.size();
            }
        }

        return freshCounter == 0 ? depth : -1;

    }
}