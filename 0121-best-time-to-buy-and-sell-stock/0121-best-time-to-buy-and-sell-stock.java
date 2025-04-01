class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int minBuy = prices[0];
        int bestProfit = 0;

        for (int i=1; i<prices.length; i++)
        {
            bestProfit = Math.max(bestProfit, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return bestProfit;

        
    }
}