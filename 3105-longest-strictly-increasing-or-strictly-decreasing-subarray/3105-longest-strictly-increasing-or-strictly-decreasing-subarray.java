class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int longestAsc = 1;
        int longestDesc = 1;
        int longest = 1;

        int currAsc = 1;
        int currDesc = 1;

        for (int i=1; i<nums.length; i++)
        {
            if (nums[i-1] < nums[i])
            {
                currAsc += 1;
                longest = Math.max(longest, currDesc);
                currDesc = 1;
            } else if (nums[i-1] > nums[i])
            {
                currDesc += 1;
                longest = Math.max(longest, currAsc);
                currAsc = 1;
            } else {
                longest = Math.max(longest, Math.max(currAsc, currDesc));
                currAsc = 1;
                currDesc = 1;
            }
        }

        return Math.max(longest, Math.max(currAsc, currDesc));
    }
}