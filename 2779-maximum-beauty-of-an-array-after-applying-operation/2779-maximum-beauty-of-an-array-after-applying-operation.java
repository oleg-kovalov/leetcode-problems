class Solution {
    record Interval(int start, int end) {}
    public int maximumBeauty(int[] nums, int k) {
        Map<Interval, Integer> intervalFreqs = new HashMap<>();

        for (int num: nums)
        {
            Interval interval = new Interval(num - k, num + k);
            intervalFreqs.put(interval, intervalFreqs.getOrDefault(interval, 0) + 1);
        }

        List<int[]> line = new ArrayList<>();
        for (Map.Entry<Interval, Integer> entry: intervalFreqs.entrySet())
        {
            line.add(new int[] {entry.getKey().start(), entry.getValue()});
            line.add(new int[] {entry.getKey().end() + 1, -1 * entry.getValue()});
        }

        // sort, ends go first in case of tie 
        Collections.sort(line, (a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int maxIntersection = 0;
        int runningSum = 0;
        for (int i=0; i<line.size(); i++)
        {
            runningSum += line.get(i)[1];
            maxIntersection = Math.max(maxIntersection, runningSum);
        }

        return maxIntersection;



    }
}