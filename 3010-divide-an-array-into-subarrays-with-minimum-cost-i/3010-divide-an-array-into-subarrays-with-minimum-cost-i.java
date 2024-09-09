class Solution {
    public int minimumCost(int[] nums) {
        int result = nums[0];

        nums[0] = Integer.MAX_VALUE;
        Arrays.sort(nums);

        result += nums[0] + nums[1];

        return result;
    }
}