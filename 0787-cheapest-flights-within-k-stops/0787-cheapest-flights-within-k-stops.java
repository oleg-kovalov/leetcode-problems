class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        

        int[] prices = new int[n];
        for (int i=0; i<prices.length; i++)
        {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;

        for (int i=0; i<k+1; i++)
        {
            // System.out.println(Arrays.toString(prices));
            int[] nextPrices = Arrays.copyOf(prices, prices.length);
            for (int[] f: flights)
            {
                int from = f[0], to = f[1], price = f[2];

                if (prices[from] == Integer.MAX_VALUE) continue; // wa haven't reached source city yet
                if (prices[from] + price < nextPrices[to])
                {
                    nextPrices[to] = prices[from] + price;
                }
            }
            prices = nextPrices;
        }

        // System.out.println(Arrays.toString(prices));
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;

    }
}