class Solution {
    public int findPairs(int[] nums, int k) {
        
            // [2,2,4,5,6]   ,2
            // [1,1,3,4,5] , 2

            int count = 0;
            Arrays.sort(nums);

            for (int i=0; i<nums.length; i++)
            {
                if (i > 0 && nums[i] == nums[i-1]) continue;

                int num = nums[i];

                int upper = search(nums, i+1, nums.length - 1, num + k);
                if (upper >= 0)
                {
                    count += 1;
                }
            }

            return count;

    }

    private int search(int[] nums, int lo, int hi, int target)
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
}