class Solution {
    public int removeDuplicates(int[] nums) {
        int readPointer = 0;
        int writePointer = 0;
        int prevNum = -101;

        for (int num : nums)
        {
            if (num == prevNum)
            {
                readPointer++;
            }
            else
            {
                if (readPointer > writePointer)
                {
                    nums[writePointer] = nums[readPointer];
                }
                prevNum = num;
                readPointer++;
                writePointer++;
            }
        }

        // System.out.println(Arrays.toString(nums));

        return writePointer;
    }
}