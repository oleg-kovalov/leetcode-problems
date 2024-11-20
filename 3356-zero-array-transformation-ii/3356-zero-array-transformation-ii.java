class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        int result = Integer.MAX_VALUE;
        int lo = -1; 
        int hi = queries.length;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (enoughQueries(mid, queries, nums))
            {
                // this is valid result, try to search better
                result = Math.min(result, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (result == -1) return 0; //-1 means no queries needed

        return result == Integer.MAX_VALUE ? -1 : result;      
    }

    private boolean enoughQueries(int mid, int[][] queries, int[] nums)
    {
        int[] diffArray = new int[nums.length + 1];
        for (int i=0; i<mid; i++)
        {
            diffArray[queries[i][0]] += queries[i][2];
            diffArray[queries[i][1] + 1] -= queries[i][2];
        }

        int runningSum = diffArray[0]; 
        for (int i=1; i<diffArray.length; i++)
        {
            runningSum += diffArray[i];
            diffArray[i] = runningSum;
        }

        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] - diffArray[i] > 0) return false;
        }

        return true;
    }
}