class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int hi = 0;
        for (int num: nums) 
        {
            if (num > hi) hi = num;
        }  
        int maxPossibleBags = nums.length + maxOperations;

        int lo = 1;
        int result = hi;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            long neededBags = 0;
            for (int num: nums)
            {
                neededBags += num / mid + (num % mid == 0 ? 0 : 1);
            }
            if (neededBags > maxPossibleBags)
            {
                lo = mid + 1;
            } else {
                result = mid;
                hi = mid - 1;
            }
        }

        return result;

    
    }
}