class Solution {

    public int wiggleMaxLength(int[] nums) {

        int[][] dp = new int[nums.length][2]; // 0 - incr, 1 - decr
        dp[nums.length-1][0] = 1;
        dp[nums.length-1][1] = 1;

        for (int i=nums.length-2; i>=0; i--)
        {
            int curr = nums[i];
            int next = nums[i+1];

            if (curr < next)
            {
                dp[i][0] = Math.max(
                    1 + dp[i+1][1], //take
                    dp[i+1][0]); //skip

                dp[i][1] = dp[i+1][1]; //skip
            } else if (curr > next) {
                dp[i][1] = Math.max(
                    1 + dp[i+1][0], //take
                    dp[i+1][1]); //skip

                dp[i][0] = dp[i+1][0]; //skop
            } else {
                dp[i][0] = dp[i+1][0]; // skip
                dp[i][1] = dp[i+1][1]; // skip
            }
        }

        return Math.max(dp[0][0], dp[0][1]);

    }










//  TOP - DOWN

    // int[][] memo;
    // public int wiggleMaxLength(int[] nums) {
    //     memo = new int[nums.length][2]; 
    //     for (int i=0; i<nums.length; i++)
    //     {
    //         Arrays.fill(memo[i], -1);
    //     }

    //     return Math.max(
    //         1 + backtrack(1, true, nums),
    //         1 + backtrack(1, false, nums)
    //     );

    // }

    // private int backtrack(int idx, boolean incr, int[] nums)
    // {
    //     if (idx == nums.length) return 0;

    //     if (memo[idx][incr ? 1 : 0] != -1) return memo[idx][incr ? 1 : 0];

    //     int curr = nums[idx];
    //     int prev = nums[idx-1];
    //     if ((incr && prev < curr) || (!incr && prev > curr))
    //     {
    //         return memo[idx][incr ? 1 : 0] = 
    //             Math.max(
    //                 1 + backtrack(idx + 1, !incr, nums),  //take
    //                 backtrack(idx + 1, incr, nums)); //skip
    //     } else {
    //         return memo[idx][incr ? 1 : 0] = 
    //             backtrack(idx + 1, incr, nums); //skip
    //     }
    // }
}