class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i=0; i<dp.length; i++)
        {
            dp[i] = 1000_000_000;
        }        

        dp[0] = 0;
        // for (int coin: coins)
        // {
        //     dp[coin] = 1;
        // }

        for (int i=1; i<amount+1; i++)
        {
            for (int coin: coins)
            {
                if (i - coin >= 0)
                {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }   
        }

        if (dp[amount] > 10_001) return -1;
        return dp[amount];
    }
}