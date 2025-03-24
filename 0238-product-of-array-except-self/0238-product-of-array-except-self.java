class Solution {
    public int[] productExceptSelf(int[] nums) {
        // calculate suffix in result array
        int[] result = new int[nums.length];
        result[nums.length - 1] = nums[nums.length - 1];
        for (int i=nums.length-2; i>=0; i--)
        {
            result[i] = result[i+1] * nums[i];
        }

        // calculate prefix in input array
        for (int i=1; i<nums.length; i++)
        {
            nums[i] = nums[i-1] * nums[i];
        }

        for (int i=0; i<nums.length; i++)
        {
            int left = i == 0 ? 1 : nums[i-1];
            int right = i == nums.length - 1 ? 1 : result[i+1];

            result[i] = left * right; 
        }
        
        return result;

    }
}