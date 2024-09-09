class Solution {
    public void moveZeroes(int[] nums) {
        int earliestZero = -1;
        int current = 0;

        while (current < nums.length) {
            if (nums[current] == 0 && earliestZero < 0)
            {
                earliestZero = current;
            }
            else if (nums[current] != 0 && earliestZero >=0)
            {
                int temp = nums[current];
                nums[current] = nums[earliestZero];
                nums[earliestZero] = temp;
                earliestZero++;
            }

            current++;
        }
    }
}