class Solution {
    public int maxArea(int[] height) {
        
        int l = 0; 
        int r = height.length - 1; 
        int volume = 0; 

        while (l < r)
        {
            int heightL = height[l];
            int heightR = height[r]; 

            volume = Math.max(volume, (r - l) * Math.min(heightL, heightR));

            if (heightL < heightR)
            {
                l++;
            } else {
                r--;
            }
        }

        return volume;
    }
}