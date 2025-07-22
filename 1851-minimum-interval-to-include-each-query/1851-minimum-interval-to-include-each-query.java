class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        // end, length
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        int maxEnd = -1;
        for (int[] interval: intervals)
        {
            maxEnd = Math.max(maxEnd, interval[1]);
        }

        // point, idx 
        PriorityQueue<int[]> minHeap2 = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for (int i=0; i<queries.length; i++)
        {
            minHeap2.offer(new int[] {queries[i], i});
        }

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
 
        int iidx = 0;
        while (minHeap2.size() > 0)
        {
            int[] entry = minHeap2.poll();
            int point = entry[0], qidx = entry[1];

            while (iidx < intervals.length && intervals[iidx][0] <= point)
            {
                int end = intervals[iidx][1];
                int len = end - intervals[iidx][0] + 1;
                minHeap.offer(new int[] {end, len});
                iidx += 1;
            }

            while (minHeap.size() > 0 && minHeap.peek()[0] < point)
            {
                minHeap.poll();
            }

            if (minHeap.size() > 0) {
                result[qidx] = minHeap.peek()[1];
            }
        }

        return result;
    }
}