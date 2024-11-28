class Solution {
    public int minimumObstacles(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});

        while (minHeap.size() > 0)
        {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) return cost;

            if (visited[row][col]) continue;

            for (int[] direction: directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length)
                {
                    minHeap.offer(new int[] {cost + grid[newRow][newCol], newRow, newCol});
                }
            }

            visited[row][col] = true;

        }

        return 0;
    }
}