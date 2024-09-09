class Solution {
    record Remaining (int n, int target) {};
    HashMap<Remaining, Integer> cache = new HashMap<>();

    public int numRollsToTarget(int n, int k, int target) {
         return numRollsToTargetRec(n, k, target);
    }

    private int numRollsToTargetRec(int n, int k, int target)
    {
        // if (n == 0) return 0;
        if (target / n < 1) return 0;
        if (n == 1 && target > k) return 0;


        final Remaining remaining = new Remaining(n, target);

        if (cache.containsKey(remaining))
        {
            return cache.get(remaining);
        }


        int nums = 0;
        if (n == 1)
        {
            nums = 1;
        }
        else
        {
            for (int i=1; i<=k; i++)
            {
                if (target - i >= 0) {
                    nums = (nums + numRollsToTargetRec(n-1, k, target-i)) % 1000_000_007;
                }
            }
        }

        cache.put(remaining, nums);
        return nums;
    }
}