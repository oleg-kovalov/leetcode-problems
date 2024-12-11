class Solution {
    public int maxLength(int[] ribbons, int k) {
        
        int hi = 0;
        for (int ribbon: ribbons)
        {
            hi = Math.max(hi, ribbon);
        }
        
        int lo = 1;
        int result = 0;
        while (lo <= hi)
        {
            int mid = (lo + hi) /2;
            int count = 0;
            for (int ribbon: ribbons)
            {
                count += ribbon / mid;
                if (count >= k) break;
            }
            if (count >= k)
            {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }

        return result;

    }

}