class Solution {
    public int removeDuplicates(int[] nums) {

        int write = 1;
        int count = 1;
        for (int read=1; read < nums.length; read++)
        {
            if (nums[read] == nums[read-1])
            {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2)
            {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;

    }
}