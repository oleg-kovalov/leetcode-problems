class Solution {
    public int maxProduct(int[] nums) { // 2 -5 -2 -4 3
//                                               ^
        int result = nums[0]; // 2
        int higher = nums[0]; // 20
        int lower = nums[0];  // -10

        for (int i=1; i<nums.length; i++)
        {
            int num = nums[i]; 
            int newHigher = Math.max(num, Math.max(higher * num, lower * num)); // 20
            int newLower = Math.min(num, Math.min(higher * num, lower * num)); // -5 
            
            higher = newHigher;
            lower = newLower;
            result = Math.max(result, higher);
        }
    

        return result;
    }
}