class Solution {
    public int maxProduct(int[] nums) { 

        // ideal subarray would not contain zeroes
        // and would contain EVEN number of negatives
        // if there is ODD number of negatives, best subarray end exactly before negative
        // do two runs from left to right and reverse to calculate prefix product up to extra negative

        int result = nums[0];

        int prefix = 1;
        for (int i=0; i<nums.length; i++)
        {
            prefix *= nums[i];
            result = Math.max(result, prefix);

            if (prefix == 0) prefix = 1;
        }

        prefix = 1;
        for (int i=nums.length - 1; i >= 0; i--)
        {
            prefix *= nums[i];
            result = Math.max(result, prefix);

            if (prefix == 0) prefix = 1;
        }


        return result;


    }
}