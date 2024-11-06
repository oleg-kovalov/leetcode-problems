class Solution {
    public boolean canSortArray(int[] nums) {

        if (nums.length == 1) return true;

        for (int i=0; i<nums.length - 1; i++)
        {
            for (int j=0; j< nums.length - 1; j++)
            {
                if (nums[j] > nums[j+1])
                {
                    if (bitCount(nums[j]) != bitCount(nums[j+1])) return false;

                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return true;
    }

    private int bitCount (int num)
    {
        int count = 0;
        while (num > 0)
        {
            if ((num | 1) == num) count++;

            num = num >> 1;
        }

        return count;
    }
}