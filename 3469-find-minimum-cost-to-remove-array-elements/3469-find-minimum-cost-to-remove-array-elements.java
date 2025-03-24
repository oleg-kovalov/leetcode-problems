class Solution {
    int[][] dp;
    
    public int minCost(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];
        for (int i=0; i<dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return rec(nums, 0, 1);
    }

    private int rec (int[] nums, int pref, int i)
    {
        // there are no values to the right, but might be prefix value 
        if (i >= nums.length)
        {
            return (pref < nums.length) ? nums[pref] : 0;
        }
        // there is exact one value to the right and might be prefix value
        if (i == nums.length - 1)
        {
            return (pref < nums.length) ? Math.max(nums[pref], nums[i]) : nums[i];
        }
        if (dp[pref][i] >= 0) return dp[pref][i];

        // choose 3 combinations
        // prefix and 1st right value
        // prefix and 2nd right value
        // 1st and 2nd right values
        int result = Math.max(nums[pref], nums[i]) + rec(nums, i+1, i+2);
        result = Math.min(result, Math.max(nums[pref], nums[i+1]) + rec(nums, i, i+2));
        result = Math.min(result, Math.max(nums[i], nums[i+1]) + rec(nums, pref, i+2));
        dp[pref][i] = result;

        return result;
    }
}