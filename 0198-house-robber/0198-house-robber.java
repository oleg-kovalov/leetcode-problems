class Solution {
    Integer[] cache;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        cache = new Integer[nums.length];
        int result = 0;
        for (int i=0; i<2; i++)
        {
            result = Math.max(result, maxRobbery(i, nums));
        }

        return result;
    }

    private int maxRobbery(int current, int[] nums)
    {
        if (cache[current] != null)
            return cache[current];

        int nextRobberies = 0;
        for (int i=current+2; i < nums.length; i++)
        {
            nextRobberies = Math.max(nextRobberies, maxRobbery(i, nums));
        }

        int currentRobbery = nextRobberies + nums[current];

        cache[current] = currentRobbery;
        return currentRobbery;
    }
}