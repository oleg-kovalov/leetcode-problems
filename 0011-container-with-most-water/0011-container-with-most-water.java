class Solution {
    public int maxArea(int[] height) {
        int largestVolume = 0;
        int pointerL = 0;
        int pointerR = height.length -1;

        while (pointerL < pointerR)
        {
            final int heightL = height[pointerL];
            final int heightR = height[pointerR];
            largestVolume = Math.max(largestVolume, Math.abs(pointerL - pointerR) * Math.min(heightL, heightR));

            if (heightL < height[pointerR])
            {
                pointerL++;
            } else {
                pointerR--;
            }
        }

        return largestVolume;
    }
}