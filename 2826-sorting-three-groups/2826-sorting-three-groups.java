class Solution {
    int[][] memo;
    public int minimumOperations(List<Integer> nums) { // 3,1,2,3
        memo = new int[nums.size()][4]; 
        for (int i=0; i<memo.length; i++)
        {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 1, nums);
    }

    private int dp(int idx, int max, List<Integer> nums)
    {
        if (idx == nums.size()) return 0;
        if (memo[idx][max] != -1) return memo[idx][max]; 

        int num = nums.get(idx);

        int result;
        if (num < max)
        {
            result = 1 + dp(idx + 1, max, nums); // drop incoming number
        } else if (num == max)
        {
            result = dp(idx + 1, max, nums); // keep incoming number
        } else {
            result = Math.min(
                dp(idx + 1, num, nums), // option 1: keep incoming number, update max
                1 + dp(idx + 1, max, nums)); // option 2: drop incoming number
        }

        memo[idx][max] = result;

        return result;
    }
}