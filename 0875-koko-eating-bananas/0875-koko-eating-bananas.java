class Solution {
    public int minEatingSpeed(int[] piles, int h) { //3 6 7 11 , 8
        
        int lo = 1; 
        int hi = 1; 
        for (int pile: piles)
        {
            hi = Math.max(hi, pile);
        }

        int result = hi; // 4
        while (lo <= hi) //4 <= 3
        {
            int mid = lo + (hi - lo) / 2; // 4
            long hours = 0; // 8
            for (int pile: piles)
            {
                hours += (pile / mid) + (pile % mid == 0 ? 0 : 1);
            }

            if (hours <= h)
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