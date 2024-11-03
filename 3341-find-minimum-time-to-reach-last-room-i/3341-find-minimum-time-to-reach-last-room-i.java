class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] visited;
    public int minTimeToReach(int[][] moveTime) {
        visited = new boolean[moveTime.length][moveTime[0].length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0,0,0});
        visited[0][0] = true;

        while (true)
        {
            int[] curr = minHeap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == moveTime.length-1 && col == moveTime[0].length-1) return time;

            for (int[] dir: directions)
            {
                int newrow = row + dir[0];
                int newcol = col + dir[1];

                if (newrow >= 0 && newrow < moveTime.length 
                    && newcol >= 0 && newcol < moveTime[0].length 
                    && !visited[newrow][newcol])
                    {
                        minHeap.offer(new int[]{Math.max(time, moveTime[newrow][newcol]) + 1, newrow, newcol});
                        visited[newrow][newcol] = true;
                    }
            }
        }

    }
}