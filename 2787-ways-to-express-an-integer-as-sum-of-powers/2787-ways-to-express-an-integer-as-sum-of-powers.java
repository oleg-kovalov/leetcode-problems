class Solution {

    int[][] memo;

    public int numberOfWays(int n, int x)
    {

        List<Integer> nums = new ArrayList<>();
        for (int i=1; Math.pow(i, x) <= n; i++)
        {
            nums.add(i);
        }

        memo = new int[n + 1][nums.size()];
        for (int i=0; i<memo.length; i++)
        {
            Arrays.fill(memo[i], -1);
        }


        return backtrack(n, 0, nums, x);
    }
    
    private int backtrack(int rem, int idx, List<Integer> nums, int x)
    {
        if (rem == 0) return 1;
        if (rem < 0) return 0;
        if (idx == nums.size()) return 0;

        if (memo[rem][idx] != -1) return memo[rem][idx];

        int result = 
            backtrack(rem - (int)Math.pow(nums.get(idx), x), idx + 1, nums, x)  //take
          + backtrack(rem, idx + 1, nums, x); //skip  

        return memo[rem][idx] = result % 1000_000_007;
    }
}