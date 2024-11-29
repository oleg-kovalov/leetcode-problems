class Solution {
    public int minimumTime(int[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        
        while (minHeap.size() > 0)
        {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == grid.length - 1 && col == grid[0].length - 1) return time;

            if (visited[row][col]) continue;

            for (int[] direction : directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length)
                {

                    // if (visited[row][col]) continue;

                    int cellTime = grid[newRow][newCol];
                    // if time is not current, we move back and forth between 2 neignboring cells,
                    // increasing time +2 each time, in worst case loosing 1 extra second
                    int wasteTime = (cellTime - time) % 2 == 0 ? 1 : 0;

                    int newTime = Math.max(cellTime + wasteTime, time + 1);   

                    minHeap.offer(new int[]{newTime, newRow, newCol});
                }
            }

            visited[row][col] = true;


        }

        return -1;
    }
}