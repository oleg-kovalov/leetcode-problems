class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int maxSum = 0;
        int runningSum = nums[0];
        for (int i=1; i < nums.length; i++)
        {
            if (nums[i-1] < nums[i])
            {
                runningSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, runningSum);
                runningSum = nums[i];
            }
        }

        return Math.max(maxSum, runningSum);
        
    }
}