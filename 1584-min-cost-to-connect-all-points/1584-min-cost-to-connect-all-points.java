class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int i=0; i<points.length; i++)
        {
            adjMap.putIfAbsent(i, new ArrayList<>());
            for (int j=i+1; j<points.length; j++)
            {
                adjMap.putIfAbsent(j, new ArrayList<>());
                
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjMap.get(i).add(new int[] {j, weight});
                adjMap.get(j).add(new int[] {i, weight});
            }
        }

        // adjMap.forEach((k,v) -> System.out.println(k.toString() + "=" 
        //     + v.stream().map(i -> Arrays.toString(i)).collect(Collectors.joining(","))));

    int sum = 0;
    Set<Integer> visited = new HashSet<>();

    // [src, dest, weight]
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
    for (int[] dw: adjMap.get(0))
    {
        minHeap.offer(new int[] {0, dw[0], dw[1]});
    }
    visited.add(0);

    while (minHeap.size() > 0)
    {
        int[] edge = minHeap.poll();
        int src = edge[0], dest = edge[1], weight = edge[2];
        
        if (visited.contains(dest)) continue;
        visited.add(dest);
        sum += weight;

        for (int[] dw: adjMap.get(dest))
        {
            int nextDest = dw[0], nextWeight = dw[1];

            if (visited.contains(nextDest)) continue;

            minHeap.offer(new int[] {dest, nextDest, nextWeight});
        }
    }

    return sum;
    }
}