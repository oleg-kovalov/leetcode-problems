class Solution {
    public int minRemoval(int[] nums, int k) {

        if (nums.length == 1) return 0;

        Arrays.sort(nums);

        int lo=0;
        int hi = nums.length -1;
        int result = Integer.MAX_VALUE;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (canBalance(mid, nums, k))
            {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result;

    }

    private boolean canBalance(int count, int[] nums, int k)
    {

        for (int i=0; i<count + 1; i++)
        {
            int left = i;
            int right = nums.length - 1 - count + i;
            if (1L * nums[right] <= 1L * nums[left] * k) return true;
        }

        return false;
    }
              
}