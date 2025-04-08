class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[0]) // left part is normal sorted
            {
                if (nums[0] <= target && target < nums[mid])
                {
                    hi = mid - 1;
                } else
                {
                    lo = mid + 1;
                }
            } else // right part is normal sorted
            {
                if (nums[mid] < target && target <= nums[nums.length - 1])
                {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }           
            }
        }

        return -1;


    }


}