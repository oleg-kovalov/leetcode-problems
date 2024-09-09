class Solution {
    public boolean isMonotonic(int[] nums)
    {
        boolean seenIncreasing = false;
        boolean seenDecreasing = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                seenIncreasing = true;
            }
            else if (nums[i] < nums[i-1]) {
                seenDecreasing = true;
            }

            if (seenIncreasing && seenDecreasing)
            {
                return false;
            }
        }

        return true;
    }
}