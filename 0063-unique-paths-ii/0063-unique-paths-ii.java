class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] oGrid) {

        memo = new int[oGrid.length][oGrid[0].length];
        for (int i=0; i<memo.length;i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, oGrid);
    }

    private int dfs(int row, int col, int[][] oGrid)
    {
        if (row  == oGrid.length) return 0;
        if (col == oGrid[0].length) return 0;
        if (oGrid[row][col] == 1) return 0;
        if (row == oGrid.length-1 && col == oGrid[0].length-1) return 1;

        if (memo[row][col] != -1) return memo[row][col];

        return memo[row][col] = 
            dfs(row + 1, col, oGrid) // move down
            +  dfs(row, col + 1, oGrid); // move right

    }
}