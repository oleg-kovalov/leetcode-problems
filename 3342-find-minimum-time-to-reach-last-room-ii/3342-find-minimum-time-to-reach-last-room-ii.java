class Solution {
    
    boolean[][] visited;
    int[][] directions = new int[][] {{1, 0},{-1,0},{0,1},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        visited = new boolean[moveTime.length][moveTime[0].length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] { 0, 0, 0, 1});

        while (minHeap.size() > 0)
        {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];
            int moveCost = curr[3];

            if (row == moveTime.length-1 && col == moveTime[0].length-1) return time;

            for (int[] dir: directions)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < moveTime.length 
                    && newCol >= 0 && newCol < moveTime[0].length 
                    && !visited[newRow][newCol])
                {
                    minHeap.offer(new int[] {
                        Math.max(time, moveTime[newRow][newCol]) + moveCost, 
                        newRow, 
                        newCol, 
                        (moveCost == 1 ? 2 : 1)} );    
                }
            }

        }

        return -1;
    }

}