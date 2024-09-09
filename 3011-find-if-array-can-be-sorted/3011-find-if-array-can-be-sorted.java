class Solution {
    public boolean canSortArray(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                if (Integer.bitCount(nums[j]) != Integer.bitCount(nums[j-1]))
                {
                    return false;
                }

                int tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }

//        System.out.println(Arrays.toString(nums));

        return true;
    }
}