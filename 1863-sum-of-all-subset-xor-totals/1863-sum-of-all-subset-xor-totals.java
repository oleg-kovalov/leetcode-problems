class Solution {
    static int result;

    public int subsetXORSum(int[] nums) {
        result = 0;

        subsetBtrc(nums, 0, 0);

        return result;
    }

    private void subsetBtrc (int[] nums, int currXor, int startFrom)
    {

        for (int i = startFrom; i < nums.length; i++)
        {
            currXor ^= nums[i];
            result += currXor;
            subsetBtrc(nums, currXor, i+1);
            currXor ^= nums[i];
        }
    }
}