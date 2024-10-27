class Solution {
    int[][] memo;
    public int countSquares(int[][] matrix) {
        int result = 0;
        
        memo = new int[matrix.length][matrix[0].length];
        for (int i=0; i< matrix.length; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        for (int i=0; i< matrix.length; i++)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                result += solve(i, j , matrix);
            }
        }

        return result;
    }

    private int solve(int i, int j, int[][] matrix)
    {
        if (i >= matrix.length || j >= matrix[0].length)
        {
            return 0;
        }

        if (matrix[i][j] == 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int right = solve(i, j+1, matrix);
        int below = solve(i+1, j, matrix);
        int diagonal = solve(i+1, j+1, matrix);

        memo[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
        
        return memo[i][j];
    }


}