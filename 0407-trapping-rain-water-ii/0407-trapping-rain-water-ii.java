class Solution {
    public int trapRainWater(int[][] heightMap) {
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        
        // right, down, left, top
        int[][] directions = new int[][]{{0,1},{1,0}, {0,-1},{-1,0} };

        PriorityQueue<int[]> borders = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        for (int row=0; row < heightMap.length; row++)
        {
            for (int col=0; col < heightMap[0].length; col++)
            {
                if (row == 0 || row == heightMap.length-1 ||col == 0 || col == heightMap[0].length-1)
                {
                    borders.offer(new int[] {heightMap[row][col], row, col});
                    visited[row][col] = true;
                }
            }
        }

        int volume = 0;
        
        while (borders.size() > 0)
        {
            int[] curr = borders.poll();
            int height = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir: directions)
            {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (0 <= newRow && newRow < heightMap.length 
                    && 0 <= newCol && newCol < heightMap[0].length 
                    && !visited[newRow][newCol])
                {
                    int newHeight = heightMap[newRow][newCol];

                    if (newHeight < height)
                    {
                        volume += height - newHeight;
                    }
                    
                    borders.offer(new int[] {Math.max(height, newHeight), newRow, newCol});

                    visited[newRow][newCol] = true; 
                }
            } 

        }

        return volume;
    }
}