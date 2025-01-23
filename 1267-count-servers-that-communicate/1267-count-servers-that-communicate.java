class Solution {
    public int countServers(int[][] grid) {
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        List<int[]> servers = new ArrayList<>();

        for (int row=0; row < grid.length; row++)
        {
            for (int col=0; col < grid[0].length; col++)
            {
                if (grid[row][col] == 1)
                {
                    rowCount[row] += 1;
                    colCount[col] += 1;
                    servers.add(new int[]{row,col});
                }
            }
        }

        int result = 0;
        for (int[] server: servers)
        {
            if (rowCount[server[0]] > 1 || colCount[server[1]] > 1)
            {
                result += 1;
            }
        }

        return result;
    }
}