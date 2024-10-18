class Solution {
    int result = 0;
    int maxOr = 0;
    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums)
        {
            maxOr |= num;
        }

        rec(nums, 0, 0);

        return result;
    }

    private void rec(int[] nums, int idx, int or) {
        if (idx == nums.length)
        {
            if (or == maxOr)
            {
                result += 1;
            }
            return;
        }

        rec(nums, idx+1, or | nums[idx]); //take
        rec(nums, idx+1, or ); // no take
        
    }
}