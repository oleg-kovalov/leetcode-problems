class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};


        // count all islands of grid2, checking if each sell is also land in grid1
        // mark processed cells as '3'
        int subIslandCount = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int row=0; row < grid2.length; row++)
        {
            for (int col=0; col < grid2[row].length; col++)
            {
                int current = grid2[row][col];
                if (current == 1)
                {
                    boolean subIsland = true;
                    queue.offer(new int[]{row, col});
                    while (queue.size() > 0)
                    {
                        int[] cell = queue.poll();
                        int cellRow = cell[0];
                        int cellCol = cell[1];

                        if (grid2[cellRow][cellCol] == 3) continue;

                        for (int[] direction : directions)
                        {
                            int siblingRow = cellRow + direction[0];
                            int siblingCol = cellCol +  direction[1];
                            if (0 <= siblingRow && siblingRow < grid2.length
                                && 0 <= siblingCol && siblingCol < grid2[0].length
                                && grid2[siblingRow][siblingCol] == 1)
                            {
                                queue.offer(new int[]{siblingRow, siblingCol});
                            }
                        }
                        
                        subIsland &= (grid1[cellRow][cellCol] == 1);
                        grid2[cellRow][cellCol] = 3;
                    }


                    if (subIsland) subIslandCount+= 1;

                }

            }
        }


        return subIslandCount;
    }
}