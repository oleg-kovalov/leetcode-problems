class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int row=0; row < m; row++)
        {
            for (int col=0; col < n; col++)
            {
                if (row == 0 && col == 0) continue;

                dp[row][col] = 
                    (row == 0 ? 0 : dp[row-1][col]) // move down
                    + (col == 0 ? 0 : dp[row][col-1]); // move right
            }
        }

        return dp[m-1][n-1];
    }
}