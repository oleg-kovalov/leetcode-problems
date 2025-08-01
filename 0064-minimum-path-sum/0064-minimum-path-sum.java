class Solution {
    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        
        int INVALID = (int) 1e8;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int row=0; row<rows; row++)
        {
            for (int col=0; col<cols; col++)
            {
                if (row == 0 && col == 0) continue;

                dp[row][col] = grid[row][col] + Math.min(
                    row - 1 < 0 ? INVALID : dp[row-1][col], // move down
                    col - 1 < 0 ? INVALID : dp[row][col-1]); // move right
            }
        }
        
        return dp[rows-1][cols-1];

    }
}