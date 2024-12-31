class Solution {
    public int maxSumAfterOperation(int[] nums) {
    
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];

        for (int i=1; i<nums.length; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0] + nums[i], nums[i]);

            dp[i][1] = Math.max(dp[i-1][1] + nums[i], 
                        Math.max(dp[i-1][0] + nums[i] * nums[i], nums[i] * nums[i]));
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++)
        {
            maxSum = Math.max(maxSum, dp[i][1]);
        }

        return maxSum;
    
    }
}