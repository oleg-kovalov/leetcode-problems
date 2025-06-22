class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return nums[0] > nums[1] ? nums[0] : nums[1];


        int[][] dp = new int[n][2]; //  0 - didn't rob first, 1 - robbed first
        dp[0][0] = 0;
        dp[1][0] = nums[1]; 

        dp[0][1] = nums[0];
        dp[1][1] = dp[0][1];

        for (int i=2; i<n-1; i++)
        {
            dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-2][1] + nums[i], dp[i-1][1]);
        }
        
        // if we didn't rob first we can rob last
        dp[n-1][0] = Math.max(dp[n-1-2][0] + nums[n-1], dp[n-1-1][0]);
        // if we did rob first, we can't rob last
        dp[n-1][1] = Math.max(dp[n-1-2][1], dp[n-1-1][1]);


        return Math.max(dp[n-1][0], dp[n-1][1]);

    }
}