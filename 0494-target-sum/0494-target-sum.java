class Solution {

    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        backtrack(nums, 0, target);
        return count;
    }

    private void backtrack(int[] nums, int idx, int remTarget)
    {
        if (idx == nums.length) {
            if (remTarget == 0) count++;
            return;
        }

        backtrack(nums, idx + 1, remTarget + nums[idx]);
        backtrack(nums, idx + 1, remTarget - nums[idx]);
    }

    
}