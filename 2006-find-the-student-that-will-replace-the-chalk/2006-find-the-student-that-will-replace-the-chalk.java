class Solution {
    public int chalkReplacer(int[] chalk, int k)
    {
        long[] prefixSums = new long[chalk.length];
        prefixSums[0] = chalk[0];
        for (int i=1; i<prefixSums.length; i++)
        {
            prefixSums[i] = prefixSums[i-1] + chalk[i];
        }

        long sumOneLap = prefixSums[prefixSums.length-1];
        k %= sumOneLap;

        int low = 0;
        int high = prefixSums.length-1;
        while ( low < high)
        {
            int mid = (high + low) / 2;
            if (k < prefixSums[mid])
            {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;

    }
}