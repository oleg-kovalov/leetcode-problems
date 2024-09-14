class Solution {
    public int longestSubarray(int[] nums) {
        int largestNum = 0;

        for (int num: nums)
        {
            if (num > largestNum)
            {
                largestNum = num;
            }
        }

        int longestContiguous = 0;
        
        int i=0;
        while (nums[i] != largestNum)
        {
            i++;
        }
        int currentContiguous = 1;
        
        for (i++; i<nums.length; i++)
        {
            if (nums[i] == largestNum)
            {
                currentContiguous += 1;
            } else {
                longestContiguous = Math.max(longestContiguous, currentContiguous);
                currentContiguous = 0;
            }
        }

        longestContiguous = Math.max(longestContiguous, currentContiguous);

        return longestContiguous;
    }
}