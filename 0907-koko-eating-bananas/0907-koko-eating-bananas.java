class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int largestPile = 0;
        for (int pile: piles)
        {
            largestPile = Math.max(largestPile, pile);
        }

        int min = 1;
        int max = largestPile;
        int mid = 0;

        while (min < max)
        {

            mid = (max + min) / 2;

            int hoursToEat = h;
            for (int pile: piles)
            {
                if (pile < mid)
                {
                    hoursToEat -= 1;
                } else {
                    hoursToEat -= pile / mid;
                    hoursToEat -= pile % mid == 0 ? 0 : 1;
                }

            }

            if (hoursToEat < 0)
            {
                min = mid+1;
            } else {
                max = mid;
            }
        }

        return max;
    }
}