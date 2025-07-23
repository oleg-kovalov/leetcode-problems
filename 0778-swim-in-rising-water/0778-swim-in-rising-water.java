class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // row, col, cost
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        minHeap.offer(new int[] {0, 0, grid[0][0]});


        while (minHeap.size() > 0)
        {
            int[] entry = minHeap.poll();
            int row = entry[0], col = entry[1], cost = entry[2];

            if (row == rows-1 && col == cols-1) return cost;

            visited[row][col] = true;

            for (int[] dir: dirs)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (0 <= newRow && newRow < rows
                && 0 <= newCol && newCol < cols
                && !visited[newRow][newCol])
                {
                    minHeap.offer(new int[] {newRow, newCol, Math.max(cost, grid[newRow][newCol])});
                }
            }
        }

        return -1;

    }
}