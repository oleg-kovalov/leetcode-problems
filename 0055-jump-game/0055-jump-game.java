class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        
        int reachable = nums.length-1;
        for (int i=nums.length-2; i>=0; i--)
        {
            if (i + nums[i] >= reachable)
            {
                reachable = i;
            }
        }

        return reachable == 0;

    }
}