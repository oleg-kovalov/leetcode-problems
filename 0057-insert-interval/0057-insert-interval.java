class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };

        Map<Integer, Integer> line = new TreeMap<>();

        for (int[] interval : intervals) {
            line.put(interval[0], line.getOrDefault(interval[0], 0) + 1);
            line.put(interval[1], line.getOrDefault(interval[1], 0) - 1);
        }
        line.put(newInterval[0], line.getOrDefault(newInterval[0], 0) + 1);
        line.put(newInterval[1], line.getOrDefault(newInterval[1], 0) - 1);

        List<int[]> result = new ArrayList<>();
        int runningCount = 0;
        int start = -1;
        for (Map.Entry<Integer, Integer> entry : line.entrySet()) {
            // interval can be zero length
            if (runningCount == 0) {
                start = entry.getKey();
            }

            runningCount += entry.getValue();
            if (runningCount == 0) {
                result.add(new int[] { start, entry.getKey() });
            }
        }

        return result.toArray(new int[result.size()][2]);

    }
}