class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        memo = new int[amount + 1];
        
        int result = backtrack(amount, coins);
        
        if (result >= 1000_000_000) return -1;
        return result;

    }

    private int backtrack(int amount, int[] coins)
    {
        if (amount == 0) return 0;
        if (amount < 0) return 1000_000_000;

        if (memo[amount] > 0) return memo[amount];

        int result = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++)
        {
            result = Math.min(result, 1 + backtrack(amount - coins[i], coins));
        }

        memo[amount] = result;
        return result;

    }


}