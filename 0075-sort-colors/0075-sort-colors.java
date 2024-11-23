class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        while (left < nums.length && nums[left] == 0)
        {
            left += 1;
        }

        int right = nums.length - 1;
        while (right >= 0 && nums[right] == 2)
        {
            right -= 1;
        }

        int curr = left;
        while (curr <= right)
        {
            if (nums[curr] == 0)
            {
                // swap with left
                int tmp = nums[left];
                nums[left] = nums[curr];
                nums[curr] = tmp;
                curr++;
                left++; 
            } else if (nums[curr] == 2)
            {
                // swap with right
                int tmp = nums[right];
                nums[right] = nums[curr];
                nums[curr] = tmp;
                right--;
            } else {
                curr++;
            }
        }
    }
}