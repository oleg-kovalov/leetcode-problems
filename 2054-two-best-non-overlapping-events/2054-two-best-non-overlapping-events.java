class Solution {
    int[][] memo;
    public int maxTwoEvents(int[][] events) {
        memo = new int[events.length][3];
        for (int[] row: memo)
        {
            Arrays.fill(row, -1);
        }

        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));

        return backtracking(events, 0, 0);
    }

    private int backtracking(int[][] events, int eventId, int selected)
    {
        if (eventId == events.length) return 0;
        if (selected == 2) return 0;

        if (memo[eventId][selected] != -1) return memo[eventId][selected];

        // skip event
        int result = backtracking(events, eventId + 1, selected);


        // choose event
        int endTime = events[eventId][1];
        int lo = eventId + 1;
        int hi = events.length -1;
        int nextEventId = events.length; // if this value remains, we didn't find next candidate
        while (lo <= hi)
        {
            int mid = (lo + hi) /2;
            if (events[mid][0] <= endTime)
            {
                lo = mid + 1;
            } else {
                nextEventId = mid;
                hi = mid - 1;
            }
        }

        result = Math.max(result, events[eventId][2] + backtracking(events, nextEventId, selected + 1));

        memo[eventId][selected] = result;

        return result;
    }
}