class Solution {
    public int[][] merge(int[][] intervals) {

        Map<Integer, Integer> points = new HashMap<>();

        int maxEnd = 0;
        for (int[] interval: intervals)
        {
            int start = interval[0];
            int end = interval[1];
            points.put(start, points.getOrDefault(start, 0) + 1);
            points.put(end, points.getOrDefault(end, 0) - 1);
            
            maxEnd = Math.max(maxEnd, end);
        }

        // System.out.println(points);

        List<int[]> result = new ArrayList<>();
        int count = 0;
        int i=0;
        int start = -1;
        while (i < maxEnd + 1)
        {
            if (points.containsKey(i))
            {
                if (count == 0)
                {
                    start = i;
                }
                count += points.get(i);
                if (count == 0)
                {
                    result.add(new int[] {start, i});
                }
            }
            i++;
        }

        return result.toArray(new int[0][0]);

    }
}