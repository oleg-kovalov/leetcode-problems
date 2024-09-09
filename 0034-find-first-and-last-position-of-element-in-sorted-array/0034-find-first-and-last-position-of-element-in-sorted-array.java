class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1,-1};
        
        // binary search for left index of target
        int l = 0;
        int r = nums.length -1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (nums[m] == target)
            {
                if (m == 0)
                {
                    result[0] = m;
                    break;
                }
                if (nums[m-1] < target)
                {
                    result[0] = m;
                    break;
                }

                r = m - 1;
            }
            else if (nums[m] < target)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }

        // binary search for right index of target
        l = 0;
        r = nums.length -1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (nums[m] == target)
            {
                if (m == nums.length -1)
                {
                    result[1] = m;
                    break;
                }
                if (nums[m+1] > target)
                {
                    result[1] = m;
                    break;
                }

                l = m + 1;
            }
            else if (nums[m] < target)
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }

        return result;
    }
}