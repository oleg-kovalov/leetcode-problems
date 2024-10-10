class Solution {
    public int maxWidthRamp(int[] nums) {
        int[][] numIndex = new int[nums.length][2];
        for (int i=0; i<nums.length; i++)
        {
            numIndex[i][0] = i;
            numIndex[i][1] = nums[i];
        }

        Arrays.sort(numIndex, (a, b) -> a[1] - b[1]);

        int minIndex = numIndex[0][0];
        int maxRamp = 0;
        for (int i=0; i<numIndex.length; i++)
        {
            if (numIndex[i][0] < minIndex)
            {
                minIndex = numIndex[i][0];
            } else {
                maxRamp = Math.max(maxRamp, numIndex[i][0] - minIndex);
            }
        }

        return maxRamp;
    }
}