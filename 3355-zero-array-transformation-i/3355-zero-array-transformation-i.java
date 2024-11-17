class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length + 1];
        
        for (int[] query: queries)
        {
            prefix[query[0]] += 1;
            prefix[query[1] + 1 ] -= 1;
        }

        for (int i=1; i<prefix.length; i++)
        {
            prefix[i] += prefix[i-1];
        }

        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] - prefix[i] > 0) return false;
        }

        return true;
    }
}