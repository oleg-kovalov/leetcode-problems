class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(intervals[0][1]);
        int maxRooms = 1;

        for (int i=1; i<intervals.length; i++)
        {
            while (minHeap.peek() !=null && minHeap.peek() <= intervals[i][0])
            {
                minHeap.poll();
            }

            minHeap.offer(intervals[i][1]);
            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}