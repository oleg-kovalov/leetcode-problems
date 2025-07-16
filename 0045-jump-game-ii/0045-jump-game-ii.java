class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i=0; i<nums.length-1; i++)
        {
            int jump = nums[i];
            for (int j=i+1; j < i+jump+1; j++)
            {
                if (j == nums.length) break;
                if (dp[j] == 0)
                {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[nums.length-1];
    }
}