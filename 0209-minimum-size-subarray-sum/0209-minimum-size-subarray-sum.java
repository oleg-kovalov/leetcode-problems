class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int lo = 1;
        int hi = nums.length;
        int result = Integer.MAX_VALUE;
        
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (subarrayExists(mid, target, nums))
            {
                // this is good, try to find better
                result = Math.min(result, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    private boolean subarrayExists(int size, int target, int[] nums)
    {

        long sum = 0L;
        for (int i=0; i < size; i++)
        {
            sum += nums[i];
        }

        int left = 0;
        int right = size - 1;

        while (right < nums.length-1 && sum < target)
        {
            sum -= nums[left];
            left++;

            sum += nums[right + 1];
            right++;
        }

        return sum >= target;
    }
    
}