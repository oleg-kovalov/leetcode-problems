class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long sumBatteries = 0L;
        for (int battery: batteries)
        {
            sumBatteries += battery;
        }

        long result = 0;
        long lo = 0;
        long hi = sumBatteries / n;


        while (lo <= hi)
        {
            long mid = lo + (hi - lo) / 2;
            // System.out.println(mid);

            if (canPower(n, batteries, mid))
            {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }

    private boolean canPower(int n, int[] batteries, long targetTime)
    {
        long time = 0L;
        for (int battery: batteries)
        {
            // battery larger than targetTime will be used by single computer for the whole time
            time += Math.min(targetTime, battery); 
        }

        return (time / n) >= targetTime;        
    }
}