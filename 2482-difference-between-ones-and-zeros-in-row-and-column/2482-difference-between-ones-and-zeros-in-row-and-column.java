class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowDiffs = new int[grid.length];
        for (int r = 0; r < grid.length; r++) {
            rowDiffs[r] = diffRow(grid, r);
        }

        int[] colDiffs = new int[grid[0].length];
        for (int c = 0; c < grid[0].length; c++) {
            colDiffs[c] = diffCol(grid, c);
        }

        int[][] diff = new int[grid.length][grid[0].length];
        for (int r = 0; r < diff.length; r++) {
            for (int c=0; c < diff[r].length; c++)
            {
                diff[r][c] = rowDiffs[r] + colDiffs[c];
            }
        }

        return diff;
    }

    private int diffCol(int[][] grid, int col)
    {
        int diff = 0;
        for (int r=0; r<grid.length; r++)
        {
            int v = grid[r][col];
            diff += (v == 0 ? -1 : 1);
        }

        return diff;
    }

    private int diffRow(int[][] grid, int row)
    {
        int diff = 0;
        for (int c=0; c<grid[row].length; c++)
        {
            int v = grid[row][c];
            diff += (v == 0 ? -1 : 1);
        }

        return diff;
    }
}