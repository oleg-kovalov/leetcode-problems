class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int maxId = findMaxId(nums);
        if (maxId == -1) return -1; //should never happen

        if (nums[0] <= target && target <= nums[maxId])
        {
            return search(nums, target, 0, maxId);
        } else if (maxId < nums.length - 1 && nums[maxId+1] <= target && target <= nums[nums.length - 1])
        {
            return search(nums, target, maxId+1, nums.length - 1);
        } else 
        {
            return -1;
        }
    }

    private int search(int[] nums, int target, int lo, int hi)
    {
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target)
            {
                lo = mid + 1;
            } else if (nums[mid] > target)
            {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int findMaxId(int[] nums)
    {
        if (nums[0] < nums[nums.length - 1]) return nums.length - 1;

        int first = nums[0];
        int lo = 0;
        int hi = nums.length - 2;

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] > nums[mid + 1])
            {
                return mid;
            }

            if (nums[mid] >= first)
            {
                lo = mid + 1;
            } else if (nums[mid] < first) {
                hi = mid - 1;
            }
        }

        return -1;

    }

}