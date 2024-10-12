class Solution {
        public int minGroups(int[][] intervals)
        {
            Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

            Map<Integer, Integer> endToCount = new TreeMap<>();

            for (int[] interval : intervals)
            {

                if (endToCount.keySet().iterator().hasNext()) {
                    int end = endToCount.keySet().iterator().next();
                    if (end < interval[0])
                    {
                        endToCount.put(end, endToCount.get(end) - 1);
                        if (endToCount.get(end) == 0)
                        {
                            endToCount.remove(end);
                        }
                    }
                }
                
                endToCount.put(interval[1], endToCount.getOrDefault(interval[1], 0) + 1);
            }

            int totalCount = 0;
            for (int count : endToCount.values())
            {
                totalCount += count;
            }

            return totalCount;
        }
}