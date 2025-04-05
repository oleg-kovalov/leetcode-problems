class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target)
            {
                lo = mid + 1;
            } else if (nums[mid] > target)
            {
                hi = mid - 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;


    }
}