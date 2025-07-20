class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] time: times)
        {
            adjMap.putIfAbsent(time[0], new ArrayList<>());
            adjMap.get(time[0]).add(new int[] {time[1], time[2]});
        }

        Map<Integer, Integer> cache = new HashMap<>(); // node -> time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1])); // node, time
        minHeap.offer(new int[] {k, 0});
        cache.put(k, 0);

        Set<Integer> seen = new HashSet<>();
        seen.add(k);
        int minTime = -1;

        while (minHeap.size() > 0)
        {
            int[] entry = minHeap.poll();
            int node = entry[0], time = entry[1];

            seen.add(node);
            minTime = Math.max(minTime, cache.get(node));
            if (seen.size() == n) return minTime;

            for (int[] next: adjMap.getOrDefault(node, new ArrayList<>()))
            {
                int nextNode = next[0], nextTime = time + next[1];

                if (cache.containsKey(nextNode) && cache.get(nextNode) <= nextTime) continue;

                minHeap.offer(new int[] {nextNode, nextTime});
                cache.put(nextNode, nextTime);
            }
        }

        return -1;
    }
}