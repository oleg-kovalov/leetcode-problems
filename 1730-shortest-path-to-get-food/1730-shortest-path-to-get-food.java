class Solution {
    public int getFood(char[][] grid) {
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        boolean[][] visited =  new boolean[grid.length][grid[0].length];

        int[] start = new int[] {-1,-1};
        List<int[]> foods = new ArrayList<>();
        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[0].length; col++)
            {
                if (grid[row][col] == '*') {
                    start = new int[] {row,col};
                } else if (grid[row][col] == '#')
                {
                    foods.add(new int[]{row,col});
                }
            }
        }

        if (foods.size() == 0) return -1;

        PriorityQueue<int[]> cells = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        cells.offer(new int[] {manhattanDist(start[0], start[1], foods), 0, start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while (cells.size() > 0)
        {
            int[] curr = cells.poll();
            int cost = curr[0];
            int steps = curr[1];
            int row = curr[2];
            int col = curr[3];

            if (grid[row][col] == '#') return steps;

            for (int[] direction: directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (0 <= newRow && newRow < grid.length 
                    && 0 <= newCol && newCol < grid[0].length
                    && grid[newRow][newCol] != 'X'
                    && !visited[newRow][newCol])
                    {
                        cells.offer(new int[] {manhattanDist(newRow, newCol, foods), steps + 1, newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
            }
            
        }

        return -1;
    }

    private int manhattanDist(int row, int col, List<int[]> foods)
    {
        int dist = Integer.MAX_VALUE;
        for (int[] food: foods)
        {
            dist = Math.min(dist, Math.abs(food[0] - row) + Math.abs(food[1] - col));
        }

        return dist;
    }
}