class Solution {
    public int minCost(int[][] grid) {
        int[][] minCost = new int[grid.length][grid[0].length]; 
        for (int row = 0; row < grid.length; row++)
        {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }

        // right, left, down, up
        int[][] directions = new int[][] { {0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> vertices = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        vertices.offer(new int[] {0, 0, 0}); // cost, row, col
        minCost[0][0] = 0;

        while (vertices.size() > 0)
        {
            int[] vertex = vertices.poll();

            // Skip if we've found a better path to this cell
            if (minCost[vertex[1]][vertex[2]] < vertex[0]) continue;            
                        
            for (int d=0; d<directions.length; d++)
            {
                int row = vertex[1] + directions[d][0];
                int col = vertex[2] + directions[d][1];
                if (0 <= row && row < grid.length && 0 <= col && col < grid[0].length)
                {
                    int cost = vertex[0] + (grid[vertex[1]][vertex[2]] == d+1 ? 0 : 1);
                    
                    if (cost < minCost[row][col]){
                        vertices.offer(new int[]{cost, row, col});
                        minCost[row][col] = cost;
                    }
                }
            }
        }

        return minCost[grid.length - 1][grid[0].length - 1];
    }
}