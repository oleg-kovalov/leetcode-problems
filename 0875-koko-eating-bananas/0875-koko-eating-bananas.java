class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;
        for (int pile: piles)
        {
            maxPile = Math.max(maxPile, pile);
        }

        int lo=1;
        int hi = maxPile;
        int result = Integer.MAX_VALUE;
        while (lo <= hi)
        {
            int mid = (hi + lo) / 2;
            long time = 0L;
            for (int pile: piles)
            {
                time += pile / mid + (pile % mid == 0 ? 0 : 1);
            }
            
            if (time <= h)
            {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result;
    }
}