class Solution {

    int[][] memo;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for (int num: nums) sum += num;

        memo = new int[nums.length+1][2 * sum +1];
        for (int i=0; i<nums.length+1; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return backtrack(nums, 0, 0, target);
    }

    private int backtrack(int[] nums, int idx, int currTarget, int target)
    {

        if (idx == nums.length) {
            if (currTarget == target) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if (memo[idx][currTarget + sum] >= 0) return memo[idx][currTarget + sum];

        memo[idx][currTarget + sum] = backtrack(nums, idx + 1, currTarget + nums[idx], target)
            + backtrack(nums, idx + 1, currTarget - nums[idx], target);


        return memo[idx][currTarget + sum];

    }

    
}