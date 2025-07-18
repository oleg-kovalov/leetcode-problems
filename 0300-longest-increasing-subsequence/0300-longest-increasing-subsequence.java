class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int result = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i=1; i<n; i++)
        {
            dp[i] = 1;
            for (int j=0; j<i; j++)
            {
                if (nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }

        return result;

    }
}