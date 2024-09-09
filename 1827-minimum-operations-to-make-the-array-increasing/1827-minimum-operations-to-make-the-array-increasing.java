class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 0) return 0;

        int totalOps = 0;
        for (int i = 1; i < nums.length; i++)
        {
            int prev = nums[i-1];
            int curr = nums[i];

            if (prev >= curr)
            {
                int currOps = prev - curr + 1;
                nums[i] = curr + currOps;
                totalOps += currOps;
            }
        }

        return totalOps;
     
    }
}