class Solution {
    public int maxOperations(int[] nums) {

        if (nums.length < 4) return 1;

        int score = nums[0] + nums[1];
        int result = 1;
        for (int i=2; i<nums.length-1; i+=2)
        {
            if (score == (nums[i] + nums[i+1]))
            {
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}