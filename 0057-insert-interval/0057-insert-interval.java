class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};

        Map<Integer, Integer> starts = new HashMap<>();
        Map<Integer, Integer> ends = new HashMap<>();

        for (int[] interval: intervals)
        {
            int start = interval[0];
            int end = interval[1];
            starts.put(start, starts.getOrDefault(start, 0) + 1);
            ends.put(end, ends.getOrDefault(end, 0) + 1);
        }
        starts.put(newInterval[0], starts.getOrDefault(newInterval[0], 0) + 1);
        ends.put(newInterval[1], ends.getOrDefault(newInterval[1], 0) + 1);

        System.out.println(starts);
        System.out.println(ends);

        List<int[]> result = new ArrayList<>();
        int maxEnd = Math.max(newInterval[1], intervals[intervals.length-1][1]);
        int count = 0;
        int start = -1;
        for (int i=0; i<maxEnd + 1; i++)
        {
            if (starts.containsKey(i)) 
            {
                count += starts.get(i);
                if (start == -1) start = i;
            }
            if (ends.containsKey(i))
            {
                count -= ends.get(i);
                if (count == 0 && start != -1)
                {
                    result.add(new int[] {start, i});
                    start = -1;
                }
            }
        }

        int[][] resultArray = new int[result.size()][2];
        for (int i=0; i<resultArray.length; i++)
        {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}