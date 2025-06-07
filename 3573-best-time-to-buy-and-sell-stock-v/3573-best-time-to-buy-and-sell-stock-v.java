class Solution {
    public long maximumProfit(int[] prices, int k) {

        // 0 - no transaction
        // 1 - holding stock in normal transaction
        // 2 - in short-selling transaction
        long[][][] dp = new long[prices.length][k + 1][3];

        for (int i=0;i<prices.length; i++)
        {
            for (int j=0; j<k+1; j++)
            {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
                dp[i][j][2] = Integer.MIN_VALUE;
            }
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = prices[0];

        for (int i=1; i<prices.length; i++)
        {
            for (int j=0; j<k+1; j++)
            {
                dp[i][j][0] = Math.max(
                    dp[i-1][j][0], //continue doing nothing
                    Math.max(
                        dp[i-1][j][1] + prices[i], // sold the stock
                        dp[i-1][j][2] - prices[i] // bought the stock from short-selling
                ));

                if (j>0)
                {
                    dp[i][j][1] = Math.max(
                        dp[i-1][j][1], //continue holding stock
                        dp[i-1][j-1][0]  - prices[i] // sold the stock in normal transaction
                    );

                    dp[i][j][2] = Math.max(
                        dp[i-1][j][2], // continue in short-selling transaction
                        dp[i-1][j-1][0] + prices[i] // start short-selling transaction
                    );
                }
            }
        }

        long result = 0L;
        for (int j=0; j < k+1; j++)
        {
            result = Math.max(result, dp[prices.length - 1][j][0]);
        }

        return result;


        // return dp[prices.length - 1][k][0];
    }
}