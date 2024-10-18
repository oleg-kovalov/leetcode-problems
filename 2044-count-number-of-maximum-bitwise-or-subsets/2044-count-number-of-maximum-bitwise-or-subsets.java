class Solution {

    int maxOr = 0;
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
    
        for (int num: nums)
        {
            maxOr |= num;
        }

        rec(nums, 0, 0);
        return count;
    }

    private void rec(int[] nums, int start, int or)
    {
        for (int i=start; i<nums.length; i++)
        {
            if ((or | nums[i]) == maxOr)
            {
                count++;
            }    
            
            rec(nums, i+1, or | nums[i] );
        }

    }
}