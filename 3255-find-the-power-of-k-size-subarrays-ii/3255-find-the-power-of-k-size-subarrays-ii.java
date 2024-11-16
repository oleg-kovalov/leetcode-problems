class Solution {
    public int[] resultsArray(int[] nums, int k) {


        int count = 1;
        for (int i=1; i<k; i++)
        {
            if (nums[i-1] == nums[i] - 1)
            {
                count++;
            } else {
                count = 1;
            }
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = (count == k) ? nums[k - 1] : -1;

        for (int i=k; i < nums.length; i++)
        {
            if (count == k) count--;

            if (nums[i-1] == nums[i] - 1)
            {
                count++;
            } else {
                count = 1;
            }

            result[i - k + 1] = (count == k) ? nums[i] : -1;
        }

        return result;

    }
}