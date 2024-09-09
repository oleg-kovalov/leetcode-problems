class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101];
        for (int i=0; i<nums.length; i++)
        {
            freq[nums[i]]++;
            if (freq[nums[i]] > 2) return false;
        }

        return true;
    }
}