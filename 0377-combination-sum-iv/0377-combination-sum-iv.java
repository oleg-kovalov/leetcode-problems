class Solution {

    int[] memo;
    public int combinationSum4(int[] nums, int target) {
    
        memo = new int[target + 1];
        Arrays.fill(memo, -1);

        return backtrack(target, nums);

    }

    private int backtrack(int rem, int[] nums)
    {
        if (rem < 0) return 0;
        if (rem == 0) return 1;

        if (memo[rem] != -1) return memo[rem];

        int result = 0;
        for (int num: nums)
        {
            result += backtrack(rem - num, nums);
        }

        return memo[rem] = result;
    }


    // public int combinationSum4(int[] nums, int target) {
        
    //     int[] dp = new int[target + 1];
    //     dp[0] = 1;

    //     for (int i=1; i<target+1; i++)
    //     {
    //         for (int num: nums)
    //         {
    //             if (i - num < 0) continue;

    //             dp[i] += dp[i-num];
    //         }
    //     }

    //     return dp[target];
    // }
}