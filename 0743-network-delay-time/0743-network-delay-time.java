class Solution {

// BELLMAN FORD
    // public int networkDelayTime(int[][] times, int n, int k) {
    
    //     int[] costs = new int[n + 1]; // 1 - based idx
    //     Arrays.fill(costs, Integer.MAX_VALUE);
    //     costs[k] = 0;

    //     for (int i=0; i<n; i++)
    //     {
    //         int[] nextCosts = Arrays.copyOf(costs, costs.length);
    //         for (int[] edge: times)
    //         {
    //             int src=edge[0], dest=edge[1], weight=edge[2];
    //             if (costs[src] == Integer.MAX_VALUE) continue;

    //             int nextCost = costs[src] + weight;
    //             nextCosts[dest] = Math.min(nextCosts[dest], nextCost);
    //         }

    //         costs = nextCosts; 
    //         // System.out.println(Arrays.toString(costs));

    //     }

    //     int result = -1;
    //     for (int i=1; i<costs.length; i++)
    //     {
    //         if (costs[i] == Integer.MAX_VALUE) return -1; // node was unreachable
    //         result = Math.max(result, costs[i]);
    //     }

    //     return result;
    // }
// }


// DIJKSTRA

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] time: times)
        {
            adjMap.putIfAbsent(time[0], new ArrayList<>());
            adjMap.get(time[0]).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1])); // node, time
        minHeap.offer(new int[] {k, 0});

        Set<Integer> visited = new HashSet<>();
        int minTime = -1;

        while (minHeap.size() > 0)
        {
            int[] entry = minHeap.poll();
            int node = entry[0], time = entry[1];

            if (visited.contains(node)) continue;

            visited.add(node);
            minTime = Math.max(minTime, time);
            if (visited.size() == n) return minTime;

            for (int[] next: adjMap.getOrDefault(node, new ArrayList<>()))
            {
                int nextNode = next[0], nextTime = time + next[1];
                minHeap.offer(new int[] {nextNode, nextTime});
            }
        }

        return -1;
    }
}