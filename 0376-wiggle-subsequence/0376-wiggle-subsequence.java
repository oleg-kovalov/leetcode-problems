class Solution {
    int[][] memo;
    public int wiggleMaxLength(int[] nums) {
        memo = new int[nums.length][2]; 
        for (int i=0; i<nums.length; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return Math.max(
            1 + backtrack(1, true, nums),
            1 + backtrack(1, false, nums)
        );

    }

    private int backtrack(int idx, boolean incr, int[] nums)
    {
        if (idx == nums.length) return 0;

        if (memo[idx][incr ? 1 : 0] != -1) return memo[idx][incr ? 1 : 0];

        int curr = nums[idx];
        int prev = nums[idx-1];
        if ((incr && prev < curr) || (!incr && prev > curr))
        {
            return memo[idx][incr ? 1 : 0] = 
                Math.max(
                    1 + backtrack(idx + 1, !incr, nums),  //take
                    backtrack(idx + 1, incr, nums)); //skip
        } else {
            return memo[idx][incr ? 1 : 0] = 
                backtrack(idx + 1, incr, nums); //skip
        }
    }
}