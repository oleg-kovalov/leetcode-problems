class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int pivot = findPivot(nums);

        if (target == nums[pivot])
        {
            return pivot;
        } 
        if (target >= nums[0] && pivot > 0)
        {
            return search(nums, 0, pivot-1, target);
        }

        return search(nums, pivot, nums.length-1, target);

    }

    private int search(int[] nums, int left, int right, int target)
    {
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
            {
                return mid;
            } else if (nums[mid] < target)
            {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findPivot(int[] nums)
    {
        if (nums[0] < nums[nums.length-1]) return 0;

        int left = 0;
        int right = nums.length -1;

        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid+1])
            {
                return mid+1;
            } else {
                if (nums[mid] >= nums[left])
                {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}