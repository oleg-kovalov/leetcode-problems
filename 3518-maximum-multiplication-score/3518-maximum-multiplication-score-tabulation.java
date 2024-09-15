class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[b.length][4]; // position in the array b and number of indices used
        for (int i=0; i<b.length; i++)
        {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        
        dp[0][0] = (long) a[0] * b[0];
        for (int i=1; i<b.length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], 1L * a[0] * b[i]);
            
            if (i >= 1)
            {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + 1L * a[1] * b[i]);
            }
            if (i >= 2)
            {
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + 1L * a[2] * b[i]);
            }
            if (i >= 3)
            {
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + 1L * a[3] * b[i]);
            }
        }
        
        return dp[b.length-1][3];
    }
}