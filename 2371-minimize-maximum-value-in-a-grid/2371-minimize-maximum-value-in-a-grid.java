class Solution {
    public int[][] minScore(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[0].length; col++)
            {
                minHeap.offer(new int[]{grid[row][col], row, col});
            }
        }

        int[] minInRow = new int[grid.length];
        int[] minInCol = new int[grid[0].length];

        while (minHeap.size() > 0)
        {
            int[] curr = minHeap.poll();
            int value = curr[0];
            int row = curr[1];
            int col = curr[2];

            int minVal = Math.max(minInRow[row], minInCol[col]) + 1;
            grid[row][col] = minVal;
            minInRow[row] = minVal;
            minInCol[col] = minVal;
        }

        return grid;
    }
}