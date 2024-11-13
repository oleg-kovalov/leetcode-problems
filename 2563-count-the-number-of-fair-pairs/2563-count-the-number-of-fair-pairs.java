class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long count = 0L;

        for (int i=0; i<nums.length-1; i++)
        {
            int left = findLeft(nums, i+1, lower - nums[i]);
            if (left == -1 ) continue;

            int right = findRight(nums, left, upper - nums[i]);
            if (right == -1) continue;

            count += right - left + 1;
        }

        return count;
    }

    private int findLeft(int[] nums, int start, int lower)
    {
        // find most left element which is >= lower bound
        int lo = start;
        int hi = nums.length-1;

        int result = -1;
        while (lo <= hi)
        {
            int mid = (hi + lo) / 2;

            if (nums[mid] < lower)
            {
                lo = mid + 1;
            } else {
                // this element is good, move left to check if better exists
                result = mid;
                hi = mid - 1;
            }
        }

        return result;
    }

    private int findRight(int[] nums, int start, int upper)
    {
        // find most left element that is <= upper
        int lo = start;
        int hi = nums.length-1;
        int result = -1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (nums[mid] > upper)
            {
                hi = mid -1;
            } else {
                // this elem is good, move left to see if better exists
                result = mid;
                lo = mid + 1;
            }
        }

        return result;
    }

}