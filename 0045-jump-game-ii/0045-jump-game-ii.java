class Solution {
    public int jump(int[] nums) { // 2, 3, 1, 0, 2, 2, 3
        if (nums.length == 1) return 0;

        int start = 0; // 2
        int far = nums[0]; // 6
        int cost = 1; // 0
        while (far < nums.length - 1)  
        {
            int prevFar = far;
            for (int i=start+1; i < prevFar+1; i++)  // 3 .. 4
            {
                if (i == nums.length - 1) return cost;
                far = Math.max(far, i + nums[i]);
            }

            cost += 1;
            start = prevFar;
        }

        return cost;
    
    }
}