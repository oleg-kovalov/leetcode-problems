class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int min = prices[0];
        int max = prices[0];

        for (int i=1; i<prices.length; i++)
        {
            int num = prices[i];
            if (num > max)
            {
                max = num;
                profit = Math.max(profit, max - min);
            } else if (num < min)
            {
                min = num;
                max = num;
            }
        }

        return profit;


    }
}