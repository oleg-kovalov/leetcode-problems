class Solution {

    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[amount + 1][coins.length];
        for (int j=0; j<dp[0].length; j++)
        {
            dp[0][j] = 1;
        }

        for (int i=1; i<dp.length; i++)
        {
            for (int j=0; j<dp[0].length; j++)
            {
                dp[i][j] = 
                        (j == 0 ? 0 : dp[i][j-1]) //skip
                    +   (i - coins[j] < 0 ? 0 : dp[i - coins[j]][j]); // take
            }
        }

        return dp[amount][coins.length - 1];
    
    }









    // int[][] memo;
    // public int change(int amount, int[] coins) {
        
    //     memo = new int[amount + 1][coins.length + 1];
    //     for (int i=0; i<memo.length; i++)
    //     {
    //         Arrays.fill(memo[i], -1);
    //     }

    //     return dfs(amount, 0, coins);
    // }

    // private int dfs(int rem, int idx, int[] coins)
    // {
    //     if (rem == 0) return 1;
    //     if (rem < 0) return 0;
    //     if (idx == coins.length) return 0;

    //     if (memo[rem][idx] != -1) return memo[rem][idx];

    //     int result =  
    //         dfs(rem - coins[idx], idx, coins) // take (and allow to take more later)
    //         + dfs(rem, idx + 1, coins); // skip 

    //     return memo[rem][idx] = result;
    // }
}