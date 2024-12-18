class Solution {
    public int[] finalPrices(int[] prices) {

        LinkedList<int[]> incrStack = new LinkedList<>();

        for (int i=0; i<prices.length; i++)
        {
            int currPrice = prices[i];
            while (incrStack.size() > 0 && incrStack.peek()[1] >= currPrice)
            {
                int[] pop = incrStack.pop();
                prices[pop[0]] -= currPrice; 
            }

            incrStack.push(new int[] { i, currPrice });
        }

        return prices;        

    }
}