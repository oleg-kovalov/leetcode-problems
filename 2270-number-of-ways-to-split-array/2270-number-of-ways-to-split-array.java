class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++)
        {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int valid = 0;
        for (int i=1; i<nums.length; i++)
        {
            if (prefix[i-1] >= prefix[nums.length - 1] - prefix[i-1])
            {
                valid += 1;
            }
        }

        return valid;
    }
}