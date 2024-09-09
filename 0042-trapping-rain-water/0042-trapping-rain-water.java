class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int result = 0;
        record LocalMax (int coord, int height) {}
        List<LocalMax> localMaxes = new ArrayList<>();

        record Range (int leftCoord, int rightCoord) {}

        for (int i=0; i<height.length; i++)
        {
            if ((i==0 || height[i] >= height[i-1])
                && (i==height.length-1 || height[i] >= height[i+1]))
            {
                localMaxes.add(new LocalMax(i, height[i]));
            }
        }

        if (localMaxes.size() < 2) return 0;
        LocalMax leftMax = localMaxes.get(0);
        int i=1;
        while (i<localMaxes.size()) {
            LocalMax rightMaxFirstLarger = localMaxes.get(i);
            if (leftMax.height > rightMaxFirstLarger.height)
            {
                int j=i+1;
                while (j < localMaxes.size())
                {
                    LocalMax currentMax = localMaxes.get(j);
                    if (currentMax.height > rightMaxFirstLarger.height)
                    {
                        if (leftMax.height <= currentMax.height)
                        {
                            //stop search, right max is larger then left, we can calculate range
                            rightMaxFirstLarger = currentMax;
                            i=j;
                            break;
                        } else {
                            //continue search, there might be larger rightMax
                            rightMaxFirstLarger = currentMax;
                            i=j;
                        }
                    }
                    j++;
                }
            }

            System.out.printf("water between: %s - %s: %s \n", leftMax, rightMaxFirstLarger, waterBetween(height, leftMax.coord, rightMaxFirstLarger.coord));
            result += waterBetween(height, leftMax.coord, rightMaxFirstLarger.coord);
            leftMax = rightMaxFirstLarger;
            i++;
        }

        return result;
    }

    private int waterBetween (int[] height, int max1, int max2)
    {
        int water = 0;
        int borderMin = Math.min(height[max1], height[max2]);

        for (int i=max1+1; i<max2; i++)
        {
            if (height[i] < borderMin)
            {
                water += borderMin - height[i];
            }
        }


        return water;
    }
}