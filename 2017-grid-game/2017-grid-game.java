class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) return 0;

        long[] upper = new long[n];
        upper[n-1] = grid[0][n-1];
        for (int i=n-2; i>=0; i--)
        {
            upper[i] = upper[i+1] + grid[0][i];
        }

        long[] lower = new long[n];
        lower[0] = grid[1][0];
        for (int i=1; i<n; i++)
        {
            lower[i] = lower[i-1] + grid[1][i];
        }
        System.out.println(Arrays.toString(upper));
        System.out.println(Arrays.toString(lower));

        long minScore = Math.min(upper[1], lower[n-2]);
        for (int i=1; i<n-1; i++)
        {
            minScore = Math.min(minScore, Math.max(upper[i+1], lower[i-1]));
        }

        return minScore;


    }
}