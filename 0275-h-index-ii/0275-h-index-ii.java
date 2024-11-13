class Solution {
    public int hIndex(int[] citations) {
        int result = 0;
        int lo = 1;
        int hi = citations.length;

        while ( lo <= hi)
        {
            int mid = (lo + hi) / 2;
            int leastPopular = citations[citations.length - mid];

            if (leastPopular < mid) 
            {
                hi = mid - 1;
            } else {
                // this is good, check if can find better
                result = mid;
                lo = mid + 1;
            }
        }

        return result;  
    }
}