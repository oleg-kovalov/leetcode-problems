class Solution {
    int result = 0;
    int maxOr = 0;
    int[][] memo;
    public int countMaxOrSubsets(int[] nums) {
        
        for (int num : nums)
        {
            maxOr |= num;
        }

        memo = new int[nums.length][maxOr+1];
        
        return rec(nums, 0, 0);

    }

    private int rec(int[] nums, int idx, int or) {
        
        if (idx == nums.length) return 0;

        if (memo[idx][or] > 0) return memo[idx][or];

        int currCount = 0;
        if ((or | nums[idx]) == maxOr)
        {
            currCount = 1;
        }

        currCount += rec(nums, idx + 1, or | nums[idx]) + rec(nums, idx + 1, or);
        memo[idx][or] = currCount;

        return currCount;
        

    }
}