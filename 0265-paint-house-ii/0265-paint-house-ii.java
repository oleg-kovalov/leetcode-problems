class Solution {
    int[][] memo; //house to prev color
    public int minCostII(int[][] costs) {
        memo = new int[costs.length][costs[0].length];
        
        return backtrack(0, -1, 0, costs);
    }

    private int backtrack(int house, int prevColor, int cost, int[][] costs) {
        if (house == costs.length) return cost;

        if (prevColor != -1 && memo[house][prevColor] > 0) return memo[house][prevColor] + cost;

        int result = Integer.MAX_VALUE;
        for (int col=0; col < costs[house].length; col++)
        {
            if (col == prevColor) continue;

            result = Math.min(result, backtrack(house + 1, col, cost + costs[house][col], costs));
        }

        if (prevColor != -1)
        {
            memo[house][prevColor] = result - cost;
        }
    
        return result;
    }
}