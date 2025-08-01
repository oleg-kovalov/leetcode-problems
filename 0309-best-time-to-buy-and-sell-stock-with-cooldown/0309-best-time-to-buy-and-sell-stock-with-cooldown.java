class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length][3]; // 0 - empty, 1 - hold, 2 - cooldown
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = (int)-1e8;

        for (int i=1; i<prices.length; i++)
        {
            dp[i][0] = Math.max(
                dp[i-1][0], //do nothing 
                dp[i-1][2]); //do nothing after cooldown

            dp[i][1] = Math.max(
                dp[i-1][1], // do nothing
                Math.max(
                    dp[i-1][0] - prices[i], //buy
                    (i-2 < 0 ? (int)-1e8 : dp[i-2][2] - prices[i]))); //buy after cooldown

            dp[i][2] = dp[i-1][1] + prices[i]; // sell
            
        }

        // for (int i=0; i<prices.length; i++)
        // {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return Math.max(
            dp[prices.length - 1][0],
            Math.max(
                dp[prices.length-1][1],
                dp[prices.length-1][2]));

    }
}