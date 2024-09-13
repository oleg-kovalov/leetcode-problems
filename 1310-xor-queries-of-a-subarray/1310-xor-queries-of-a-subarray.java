class Solution {
    
    public int[] xorQueries(int[] arr, int[][] queries)
    {
        int[] result = new int[queries.length];

        int start = queries[0][0];
        int end = queries[0][1];
        int runningXor = 0;
        for (int i=start; i<=end; i++)
        {
            runningXor ^= arr[i];
        }
        result[0] = runningXor;

        for (int q=1; q<queries.length; q++)
        {
            int newStart = queries[q][0];
            int newEnd = queries[q][1];

            for (int i=Math.min(start, newStart); i<Math.max(start, newStart); i++)
            {
                runningXor ^= arr[i];
            }
            
            for (int i=Math.min(end, newEnd)+1; i<=Math.max(end, newEnd); i++)
            {
                runningXor ^= arr[i];
            }
            
            result[q] = runningXor;
            start = newStart;
            end = newEnd;
        }
        
        return result;
    }
}