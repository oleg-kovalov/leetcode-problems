class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i=1; i<intervals.length; i++)
        {
            int[] curr = intervals[i];

            if (prevEnd <= curr[0])
            {
                // no overlap
                prevEnd = curr[1];
            } else {
                // overlap, take interval that ends earlier
                count += 1;
                prevEnd = Math.min(prevEnd, curr[1]);
            }
        }

        return count;
    }
}