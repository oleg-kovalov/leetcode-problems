class Solution {
    int[][] memo; //store health on a cell
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        memo = new int[grid.size()][grid.get(0).size()];

        return dfs(0, 0, grid, health);
    }

    private boolean dfs(int row, int col, List<List<Integer>> grid, int health)
    {
        if (row < 0 || row > grid.size()-1 || col < 0 || col > grid.get(0).size()-1)
        {
            return false;
        }
        health -= grid.get(row).get(col);

        if (memo[row][col] >= health )
        {
            // if we already were here with same or less health, this is not the optimal path
            return false;
        }
        if (health == 0)
        {
            return false;
        }

        if (row == grid.size()-1 && col == grid.get(0).size()-1)
        {
            return true;
        }

        memo[row][col] = health;

        if (dfs(row+1,col,grid, health)) return true;
        if (dfs(row,col+1,grid, health)) return true;
        if (dfs(row-1,col,grid, health)) return true;
        if (dfs(row,col-1,grid, health)) return true;


        return false;
    }
}