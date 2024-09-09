class Solution {
    public int minimumArrayLength(int[] nums) {
        int count = 1;
        int minNonDiv = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            int current = nums[i];
            if (current == minNonDiv)
            {
                count++;
            }
            else if (current % minNonDiv == 0 || minNonDiv % current == 0)
            {
                if (minNonDiv == Math.min(current, minNonDiv))
                {

                } else {
                    minNonDiv = current;
                    count =1;
                }
            }
            else {
                count = 0;
            }
        }
        
        int result = (count / 2) + (count % 2);

        return result != 0 ? result : 1;
    }
}