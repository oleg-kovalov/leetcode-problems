class Solution {
    public int findMin(int[] nums) { //3 4 5 1 2

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int first = nums[0]; // 3
        int lo = 1; // 1
        int hi = nums.length - 2; //3

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2; // 2

            if (first > nums[mid]) 
            {
                if (first == nums[mid - 1]) return nums[mid];
                hi = mid - 1;
            } else
            {
                if (first > nums[mid + 1]) return nums[mid + 1];
                lo = mid + 1;
            }
        }

        return -1;

    }
}