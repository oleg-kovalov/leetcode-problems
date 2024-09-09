class Solution {
    private  HashMap<Integer, Integer> localMin;
    private  HashMap<Integer, Integer> localMax;

    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int localMin = prices[0];
        int result  = 0;

        for (int i=1; i<prices.length; i++)
        {
            localMin = Math.min(localMin, prices[i]);
            result = Math.max(result, prices[i] - localMin);
        }

        return result;
    }
}