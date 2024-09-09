class Solution {
    public int maxProductDifference(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > secondMax)
            {
                if (num > max)
                {
                    secondMax = max;
                    max = num;
                } else {
                    secondMax = num;
                }
            }

            if (num < secondMin)
            {
                if (num < min){
                    secondMin = min;
                    min = num;
                } else {
                    secondMin = num;
                }
            }
        }

        return max * secondMax - min * secondMin;
    }
}