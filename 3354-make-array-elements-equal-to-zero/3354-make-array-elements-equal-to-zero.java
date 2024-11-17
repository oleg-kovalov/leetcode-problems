class Solution {
    public int countValidSelections(int[] nums) {

        int[] prefixLeft = new int[nums.length];
        int rollingSum = 0;
        for (int i=0; i<nums.length; i++)
        {
            rollingSum += nums[i];
            prefixLeft[i] = rollingSum;
        }

        int[] prefixRight = new int[nums.length];
        rollingSum = 0;
        for (int i=nums.length-1; i >= 0; i--)
        {
            rollingSum += nums[i];
            prefixRight[i] = rollingSum;
        }

        int result = 0;
        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] == 0)
            {
                if (prefixLeft[i] == prefixRight[i])
                {
                    result += 2;
                } else if (Math.abs(prefixLeft[i] - prefixRight[i]) == 1)
                {
                    result += 1;
                }
            }

        }

        return result;
    }
}