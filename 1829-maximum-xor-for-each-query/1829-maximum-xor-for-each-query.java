class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] xor = new int[nums.length];
        int all1 = (1 << maximumBit) - 1;

        int runningXor = 0;
        for (int i=0; i<nums.length; i++)
        {
            runningXor ^= nums[i];
            xor[nums.length-1-i] = runningXor;
        }

        int[] result = new int[nums.length];
        for (int i=0; i<result.length; i++)
        {
            int k = all1 ^ xor[i];
            result[i] = k;
        }

        return result;
    }
}