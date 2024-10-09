class Solution {

        public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins)
        {
            int[][] monstersAndCoins = new int[monsters.length][2];
            for (int i=0; i<monsters.length; i++)
            {
                monstersAndCoins[i][0] = monsters[i];
                monstersAndCoins[i][1] = coins[i];
            }
            Arrays.sort(monstersAndCoins, (a, b) -> a[0] - b[0]);

            // running sum of coins for monster in ASC
            long[] coinsSum = new long[monsters.length];
            long prefixSum = 0;
            for (int i=0; i<coinsSum.length; i++)
            {
                prefixSum += monstersAndCoins[i][1];
                coinsSum[i] = prefixSum;
            }

            long[] result = new long[heroes.length];
            for (int i=0; i<heroes.length; i++)
            {
                result[i] = findTotalCoins(heroes[i], monstersAndCoins, coinsSum);
            }

            return result;

        }

        private long findTotalCoins(int hero, int[][] monstersAndCoins, long[] coinsSum)
        {
            int lo = 0;
            int hi = monstersAndCoins.length-1;

            while ( lo <= hi)
            {
                int mid = (lo + hi) /2;
                if (hero < monstersAndCoins[mid][0])
                {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            if (lo == 0 && monstersAndCoins[0][0] > hero) return 0;

            return coinsSum[hi];
        }

}