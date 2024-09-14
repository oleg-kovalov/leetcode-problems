class Solution {
        public boolean findSafeWalk(List<List<Integer>> grid, int health)
        {
            final int rows = grid.size();
            final int cols = grid.get(0).size();
            int[][] memo = new int[rows][cols];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0,health});

            while (queue.size() > 0)
            {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                if (row < 0 || row > rows-1 || col < 0 || col > cols-1 )
                {
                    continue;
                }

                int currHealth = cell[2] - grid.get(row).get(col);
                if (currHealth <= 0)
                {
                    continue;
                }

                if (row == rows-1 && col == cols-1)
                {
                    return true;
                }
                if (currHealth <= memo[row][col])
                {
                    // if we were here with same or more health, this is not the optimal path
                    continue;
                }
                memo[row][col] = currHealth;

                queue.offer(new int[]{row+1,col,currHealth});
                queue.offer(new int[]{row,col+1,currHealth});
                queue.offer(new int[]{row-1,col,currHealth});
                queue.offer(new int[]{row,col-1,currHealth});
            }

            return false;
        }
}