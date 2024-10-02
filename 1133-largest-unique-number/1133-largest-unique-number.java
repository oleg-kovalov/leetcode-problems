class Solution {
    public int largestUniqueNumber(int[] nums) {
        if (nums.length == 1) return nums[0];


        Arrays.sort(nums);

        int prev = nums[nums.length-1];
        if (prev != nums[nums.length -2]) return prev;
        
        for (int i=nums.length-2; i>=0; i--)
        {
            int curr = nums[i];
            if (curr != prev)
            {
                if (i == 0 || nums[i-1] != curr)
                {
                    return curr;
                }
            }
            prev = curr;
        }

        return -1;

    }
}