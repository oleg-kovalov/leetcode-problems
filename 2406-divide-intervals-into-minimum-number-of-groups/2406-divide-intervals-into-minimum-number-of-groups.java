class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Integer> ends = new PriorityQueue();

        for (int[] interval: intervals)
        {
            if (ends.peek() != null && ends.peek() < interval[0])
            {
                ends.poll();
            }
            ends.offer(interval[1]);
        }

        return ends.size();
    }
}