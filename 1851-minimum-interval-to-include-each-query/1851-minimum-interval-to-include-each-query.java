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
        int[] line = new int[maxEnd + 1];
        Arrays.fill(line, -1);

        int idx = 0;
        for (int i=0; i<line.length; i++)
        {
            while (idx < intervals.length && intervals[idx][0] <= i)
            {
                int end = intervals[idx][1];
                int len = end - intervals[idx][0] + 1;
                minHeap.offer(new int[] {end, len});
                idx += 1;
            }

            while (minHeap.size() > 0 && minHeap.peek()[0] < i)
            {
                minHeap.poll();
            }

            if (minHeap.size() > 0) {
                line[i] = minHeap.peek()[1];
            }
        }
        
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            int point = queries[i];
            result[i] = point >= line.length ? -1 : line[queries[i]];
        }

        return result;
    }
}