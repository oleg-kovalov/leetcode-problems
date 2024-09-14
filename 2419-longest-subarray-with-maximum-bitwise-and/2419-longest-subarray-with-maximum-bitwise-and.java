class Solution {
    public int longestSubarray(int[] nums) {
        int largestNum = 0;
        int largestCount = 0;
        
        for (int num: nums)
        {
            if (num > largestNum)
            {
                largestNum = num;
                largestCount = 1;
            } else if (num == largestNum)
            {
                largestCount += 1;
            }
        }
        
        return largestCount;
    }
}