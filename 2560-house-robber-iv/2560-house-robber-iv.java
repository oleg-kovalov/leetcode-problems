class Solution {
    public int minCapability(int[] nums, int k) {
        
        long lo = 1;
        long hi = (long)Math.pow(10, 9+5) / 2L;

        long result = Long.MAX_VALUE;
        while (lo <= hi)
        {
            long mid = lo + (hi - lo) / 2;

            int count = k;
            if (canRob(mid, k, nums))
            {
                result = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
            
        } 

        return (int) result;
    }

    private boolean canRob(long cap, int k, int[] nums)
    {
        for (int i=0; i<nums.length && k > 0; i++)
        {
            if (nums[i] <= cap)
            {
                k -= 1;
                i+= 1;
            }
        }

        return k == 0;

    }
}