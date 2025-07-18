class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int[] dp = new int[n+1]; 

        dp[0] = 0; 
        dp[1] = 1; //  single way to come to first step
        dp[2] = 2; // 2 ways to come to second step: 1+1 or 2

        for (int i=3; i<n+1; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
}