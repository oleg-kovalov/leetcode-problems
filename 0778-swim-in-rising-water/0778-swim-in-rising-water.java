class Solution {

//  KRUSKAL's
    public int swimInWater(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows * cols == 1) return grid[0][0];

        int[][] dirs = new int[][] {{1,0},{0,1}}; // down, right

        DSU dsu = new DSU(rows * cols);

        // row-col src, row-col dest, cost
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                int src = row * cols + col;
                
                for (int[] dir: dirs)
                {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (0 <= newRow && newRow < rows
                    && 0 <= newCol && newCol < cols)
                    {
                        int dest = newRow * cols + newCol;
                        int cost = Math.max(grid[row][col], grid[newRow][newCol]);
                        minHeap.offer(new int[] {src, dest, cost}); 
                    }
                }
            }
        }

        int edgeCount = rows * cols - 1; // num of edges in min spanning tree
        int maxCost = -1;
        while (edgeCount > 0)
        {
            int[] entry = minHeap.poll();

            int src = entry[0], dest = entry[1], cost = entry[2];
            
            if (dsu.isConnected(src, dest)) continue;

            dsu.union(src, dest);
            maxCost = Math.max(maxCost, cost);

            if (dsu.isConnected(0, rows * cols - 1)) return maxCost; // first and last are connected
            edgeCount -= 1;
        }

        return -1;
    }




    private class DSU
    {
        int[] parents;
        int[] ranks;


        public DSU(int n) 
        {
            parents = new int[n];
            for (int i=0; i<parents.length; i++)
            {
                parents[i] = i;
            }
            ranks = new int[n];
        }

        public int find(int v)
        {
            if (parents[v] == v) return v;

            int root = find(parents[v]);
            parents[v] = root;
            return root;
        }

        public boolean union(int a, int b)
        {
            int parentA = find(a);
            int parentB = find(b);
            
            if (parentA == parentB) return false; // already connected

            int rankA = ranks[a];
            int rankB = ranks[b];

            if (rankA < rankB)
            {
                parents[parentA] = parentB;
            } else if (rankA > rankB)
            {
                parents[parentB] = parentA;
            } else {
                parents[parentB] = parentA;
                ranks[parentA] += 1;
            }

            return true;
        }

        public boolean isConnected(int a, int b)
        {
            return find(a) == find(b);   
        }
    
    }

//  DIJKSTRA

    // public int swimInWater(int[][] grid) {
    //     int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     boolean[][] visited = new boolean[rows][cols];

    //     // row, col, cost
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
    //     minHeap.offer(new int[] {0, 0, grid[0][0]});


    //     while (minHeap.size() > 0)
    //     {
    //         int[] entry = minHeap.poll();
    //         int row = entry[0], col = entry[1], cost = entry[2];

    //         if (row == rows-1 && col == cols-1) return cost;

    //         visited[row][col] = true;

    //         for (int[] dir: dirs)
    //         {
    //             int newRow = row + dir[0];
    //             int newCol = col + dir[1];

    //             if (0 <= newRow && newRow < rows
    //             && 0 <= newCol && newCol < cols
    //             && !visited[newRow][newCol])
    //             {
    //                 minHeap.offer(new int[] {newRow, newCol, Math.max(cost, grid[newRow][newCol])});
    //             }
    //         }
    //     }

    //     return -1;

    // }
}