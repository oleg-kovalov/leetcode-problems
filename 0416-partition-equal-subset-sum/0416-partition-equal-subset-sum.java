class Solution {

    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;

        cache = new Boolean[nums.length][sum + 1];
        
        return dfs(0, 0, 0, nums);
    }

    private boolean dfs(int sum1, int sum2, int i, int[] nums)
    {
        if (i == nums.length)
        {
            return sum1 == sum2;
        }
        int abs = Math.abs(sum1 - sum2);

        if (cache[i][abs] != null) return cache[i][abs];  

        return cache[i][abs] = dfs(sum1 + nums[i], sum2, i+1, nums)
                            || dfs(sum1, sum2 + nums[i], i+1, nums);

    }
}