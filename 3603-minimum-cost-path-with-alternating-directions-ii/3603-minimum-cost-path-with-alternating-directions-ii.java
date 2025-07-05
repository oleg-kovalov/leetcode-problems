class Solution {
    public long minCost(int m, int n, int[][] waitCost) {

        long[][] seen = new long[m][n];
        for (int i=0;i<m; i++)
        {
            Arrays.fill(seen[i], Long.MAX_VALUE);        
        }
        
        // time, row, col, cost
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a,b) -> Long.compare(a[3],b[3])); 
        minHeap.offer(new long[] {1, 0 , 0, 1});
        seen[0][0] = 1;

        while (minHeap.size() > 0)
        {
            long[] cell = minHeap.poll();
            int time = (int)cell[0], row = (int)cell[1], col = (int)cell[2];
            long cost=cell[3];

            if (row == m - 1 && col == n - 1) return cost;

            if (time % 2  == 0)
            {
                // wait
                cost += waitCost[(int)row][(int)col];
                time += 1;
            }
            if (time % 2 != 0)
            {
                // move down
                if (row + 1 < m && seen[row+1][col] > cost + (row + 2) * (col + 1)) 
                {
                    minHeap.offer(
                        new long[] {time + 1, row + 1, col, cost + (row + 2) * (col + 1)});
                    seen[row+1][col] = cost + (row + 2) * (col + 1);                    
                }

                // move right
                if (col + 1 < n && seen[row][col+1] > cost + (row + 1) * (col + 2))
                {
                    minHeap.offer(
                        new long[] {time + 1, row, col + 1, cost + (row + 1) * (col + 2)});
                    seen[row][col+1] = cost + (row + 1) * (col + 2);
                }
            }
        }

        return -1;
        
    }
}