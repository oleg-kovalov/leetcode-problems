class Solution {
        HashMap<Integer, Integer> memo;
        public int coinChange(int[] coins, int amount)
        {
            memo = new HashMap<>();

            return backtrack(coins, amount);

        }

        private int backtrack(int[] coins, int remainingAmount)
        {
            if (remainingAmount < 0) return -1;
            if (memo.containsKey(remainingAmount)) return memo.get(remainingAmount);

            if (remainingAmount == 0) return 0;


            int minRes = Integer.MAX_VALUE;
            for (int coin : coins)
            {
                int res = backtrack(coins, remainingAmount - coin);
                if (res >= 0 && res < minRes)
                {
                    minRes = res + 1;
                }
            }

            if (minRes == Integer.MAX_VALUE) {
                minRes = -1;
            }

            memo.put(remainingAmount, minRes);
            return minRes;
        }
    
}