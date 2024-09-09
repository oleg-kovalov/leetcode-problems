class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];    
    
        int[][] result = new int[m][n];
        for (int row=0; row < m; row++)
        {
            for (int col=0; col < n; col++)
            {
                result[row][col] = original[row * n + col];
            }
        }
    
        return result;

    }
}