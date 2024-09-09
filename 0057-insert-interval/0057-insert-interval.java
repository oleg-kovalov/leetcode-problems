class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsWOveralap = new ArrayList<>();

        // insert new interval according to ordering by start, intervals may overlap
        int newIdx = 0;
        for (int i=0; i<intervals.length; i++)
        {
            if (intervals[i][0] < newInterval[0])
            {
                intervalsWOveralap.add(intervals[i]);
                newIdx++;
            } else {
                break;
            }
        }
        intervalsWOveralap.add(newInterval);
        for (int i=newIdx; i < intervals.length; i++) {
            intervalsWOveralap.add(intervals[i]);
        }

        List<int[]> result = new ArrayList<>();
        for (int i=0; i<intervalsWOveralap.size(); i++)
        {
            int[] currentInterval = { intervalsWOveralap.get(i)[0], intervalsWOveralap.get(i)[1] };
            while (i < intervalsWOveralap.size() && overlap(currentInterval, intervalsWOveralap.get(i)))
            {
                currentInterval = merge(currentInterval, intervalsWOveralap.get(i));
                i++;
            }
            i--;
            result.add(currentInterval);
        }


        return result.toArray(new int[result.size()][2]);
    }

    private boolean overlap (int[] one, int[] two)
    {
        return Math.max(one[0], two[0]) <= Math.min(one[1], two[1]);
    }

    private int[] merge (int [] one, int[] two)
    {
        return new int[] { Math.min(one[0], two[0]), Math.max(one[1], two[1]) };
    }
}