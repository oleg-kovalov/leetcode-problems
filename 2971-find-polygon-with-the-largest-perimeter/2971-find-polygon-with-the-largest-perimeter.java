class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long perimeter = -1;
        long sum = nums[0]  + nums[1];
        for (int i=2; i<nums.length; i++)
        {
            int current = nums[i];
            if (current < sum)
            {
                perimeter = current + sum;
            }

            sum += current;
        }

        return perimeter;
    }
}