class Solution {
    public int countArrays(int[] original, int[][] bounds) { //3,25  [9,80][16,35]

        int[] diff = new int[original.length];
        for (int i=1; i<diff.length; i++)
        {
            diff[i] = original[i] - original[i-1]; 
        }

        int lo = bounds[0][0];
        int hi = bounds[0][1];
        for (int i=1; i<diff.length; i++)
        {
            
            lo = Math.max(lo + diff[i], bounds[i][0]);
            hi = Math.min(hi + diff[i], bounds[i][1]);
            if (lo > hi) return 0;
        }

        return hi - lo + 1;

    }
}