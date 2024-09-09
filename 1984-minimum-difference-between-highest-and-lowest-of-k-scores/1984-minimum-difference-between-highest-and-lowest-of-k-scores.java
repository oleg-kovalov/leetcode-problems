class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDelta = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int start = 0;
        int end = k - 1;
        while(end < nums.length)
        {
            // System.out.println("start " + start + " end " + end);
            int delta = nums[end] - nums[start];

            minDelta = Math.min(minDelta, delta);

            start++;
            end = start + k - 1;

        }


        return minDelta;
    }
}