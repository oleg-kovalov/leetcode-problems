class Solution {
    public boolean check(int[] nums) {


        boolean found = false;
        for (int i=1; i<nums.length; i++)
        {
            if(nums[i-1] > nums[i])
            {
                if(!found)
                {
                    found = true;
                } else return false;

            }
            
        } 
        
        return !found ? true : nums[nums.length - 1] <= nums[0];

    }
}

