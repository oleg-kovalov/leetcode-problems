class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int numsZeroToN = n + 1;
        int first = 0;
        int last = n;
        int targetSum =  (first + last) * numsZeroToN / 2; //Gauss sum of consecutive int
        
        int arraySum = 0;

        for (int i=0; i<nums.length; i++)
        {
            arraySum += nums[i];
        }

        return targetSum - arraySum;

    }
}