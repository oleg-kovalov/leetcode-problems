class Solution {

    int[][] memo;
    int sum;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        
        this.target = target;
        
        for (int num: nums)
        {
            sum += num;
        }

        memo = new int[sum * 2 + 1][nums.length];
        for (int i=0; i<memo.length; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        int result = dfs(0, 0, nums); 

        // for (int i=0; i<memo.length; i++)
        // {
        //     System.out.println(Arrays.toString(memo[i]));
        // }

        return result;
    }

    private int dfs(int amount, int idx, int[] nums)
    {
        if (amount == target && idx == nums.length) return 1;
        if (idx == nums.length) return 0;

        if (memo[sum + amount][idx] != -1) return memo[sum + amount][idx];


        int result = 
                dfs(amount - nums[idx], idx + 1, nums) // minus
            +   dfs(amount + nums[idx], idx + 1, nums); // plus

        return memo[sum + amount][idx] = result;
    }
}