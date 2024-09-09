class Solution {
    public int singleNumber(int[] nums) {
        int bitXor = 0;
        for (final int num : nums)
        {
            bitXor = bitXor ^ num;
        }
        
        return bitXor;
    }
}