class Solution {
    public int minCostClimbingStairs(int[] cost)
    {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, cost[0]);
        cache.put(1, cost[1]);

        for (int stair=2; stair < cost.length; stair++)
        {
            int currentStairCost = cost[stair];
            int minStairCost = currentStairCost + Math.min(cache.get(stair-1), cache.get(stair-2));
            cache.put(stair, minStairCost);
        }

        int minStairCostTop = Math.min(cache.get(cost.length-1), cache.get(cost.length-2));
        return minStairCostTop;
    }

}