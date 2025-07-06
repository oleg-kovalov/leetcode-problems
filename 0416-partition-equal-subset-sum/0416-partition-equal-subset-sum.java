class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num: nums) sum += num;

        if ( sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];        
        dp[0][0] = false;
        if (nums[0] <= sum / 2) dp[0][nums[0]] = false;

        for (int i=1; i<nums.length; i++)
        {
            for (int prev=0; prev < sum / 2; prev++)
            {
                if (dp[i-1][prev] == null) continue;
                dp[i][prev] = dp[i-1][prev];
                if (prev + nums[i] <= sum / 2) dp[i][prev + nums[i]] = (prev + nums[i] == sum / 2);
            }
        }

        for (int s=0; s<sum/2 + 1; s++)
        {
            if (Boolean.TRUE.equals(dp[nums.length - 1][s])) return true;
        }

        return false;
    }
}