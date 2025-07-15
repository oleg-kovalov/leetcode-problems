class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i=0; i<nums.length; i++)
        {
            int num = nums[i];
            if (!dp[i]) continue; // this cell not reacheable

            for (int j=i+1; j<i+num+1; j++)
            {
                if (j == nums.length) return true; // already enough jump
                dp[j] = true;
            }
        }

        // System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }
}