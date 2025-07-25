class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return (nums[0] > nums[1] ? nums[0] : nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i=2; i<nums.length; i++)
        {
            // maximize result between 2 choises: 
            // rob current house, add gain from all prev houses but not neighbor
            // skip current house, add gain from all prev houses including neighbor
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length - 1];

    }
}