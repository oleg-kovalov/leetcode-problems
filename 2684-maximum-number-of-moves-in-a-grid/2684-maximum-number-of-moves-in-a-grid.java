class Solution {
    int[][] memo;
    public int maxMoves(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        int maxMoves = 0;
        for (int row=0; row<grid.length; row++)
        {
            maxMoves = Math.max(maxMoves, backtrack(grid, row, 0, 0, -1));
        }
        return maxMoves;
    }

    private int backtrack(int[][]grid, int row, int col, int prev, int count)
    {
        if (row < 0 || row >= grid.length ) return count;
        if (col < 0 || col >= grid[0].length) return count;

        if (memo[row][col] > 0) return memo[row][col];

        int curr = grid[row][col];
        if (curr <= prev) return count;

        int result = count+1;
        result = Math.max(result, backtrack(grid, row-1, col+1, curr, count+1));
        result = Math.max(result, backtrack(grid, row, col+1, curr, count+1));
        result = Math.max(result, backtrack(grid, row+1, col+1, curr, count+1));

        memo[row][col] = result;
        return memo[row][col];
    }
}