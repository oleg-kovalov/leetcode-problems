class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int EMPTY=0, HOLD=1, COOLDOWN=2;
        int INVALID = (int) -1e8;

        
        int[][] dp = new int[n][3];
        dp[0][EMPTY] = 0;
        dp[0][HOLD] = -prices[0];
        dp[0][COOLDOWN] = INVALID;

        for (int i=1; i<n; i++)
        {
            dp[i][EMPTY] = Math.max(
                dp[i-1][EMPTY], //do nothing 
                dp[i-1][COOLDOWN]); //do nothing after cooldown

            dp[i][HOLD] = Math.max(
                dp[i-1][HOLD], // do nothing
                Math.max(
                    dp[i-1][EMPTY] - prices[i], //buy
                    (i-2 < 0 ? INVALID : dp[i-2][COOLDOWN] - prices[i]))); //buy after cooldown

            dp[i][COOLDOWN] = dp[i-1][HOLD] + prices[i]; // sell
            
        }

        // for (int i=0; i<prices.length; i++)
        // {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return Math.max(
            dp[n-1][EMPTY],
            Math.max(
                dp[n-1][HOLD],
                dp[n-1][COOLDOWN]));

    }
}