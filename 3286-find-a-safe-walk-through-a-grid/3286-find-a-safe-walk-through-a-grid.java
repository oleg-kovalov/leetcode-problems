class Solution {

    int[][] memo; //store health on a cell
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        memo = new int[grid.size()][grid.get(0).size()];

        return dfs(0, 0, grid, new HashSet<>(), health);
    }

    private boolean dfs(int row, int col, List<List<Integer>> grid, Set<Integer> path, int health)
    {
        if (row < 0 || row > grid.size()-1)
        {
            return false;
        }
        if (col < 0 || col > grid.get(0).size()-1)
        {
            return false;
        }
        if (memo[row][col] >= health - grid.get(row).get(col) )
        {
            return false;
        }
        if (path.contains(row * grid.size() * grid.get(0).size() + col))
        {
            return false;
        }
        if (health - grid.get(row).get(col) <= 0)
        {
            return false;
        }

        if (row == grid.size()-1 && col == grid.get(0).size()-1)
        {
            return true;
        }

        memo[row][col] = health - - grid.get(row).get(col);
        path.add(row * grid.size() * grid.get(0).size() + col);
        
        if (dfs(row+1,col,grid,path, health - grid.get(row).get(col))) return true;
        if (dfs(row,col+1,grid,path, health - grid.get(row).get(col))) return true;
        if (dfs(row-1,col,grid,path, health - grid.get(row).get(col))) return true;
        if (dfs(row,col-1,grid,path, health - grid.get(row).get(col))) return true;

        path.remove(row * grid.size() * grid.get(0).size() + col);

        return false;
    }
}