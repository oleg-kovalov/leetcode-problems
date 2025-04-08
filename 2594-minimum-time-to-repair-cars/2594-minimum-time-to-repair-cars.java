class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        int minRank = Integer.MAX_VALUE;
        for (int rank: ranks)
        {
            minRank = Math.min(minRank, rank);
        }

        long lo = 1;
        long hi = 1L * minRank * cars * cars;

        long result = hi;

        while (lo <= hi)
        {
            long mid = lo + (hi - lo) / 2;
            long repairedCars = 0;
            for (int rank: ranks)
            {
                repairedCars += Math.sqrt(mid/(double)rank); //floored
            }
            
            if (repairedCars >= cars)
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