class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] edge: edges)
        {
            adjMap.putIfAbsent(edge[0], new ArrayList<>());
            adjMap.get(edge[0]).add(edge[1]);

            adjMap.putIfAbsent(edge[1], new ArrayList<>());
            adjMap.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        visited.add(source);
        queue.offer(source);

        while (queue.size() > 0)
        {
            int vertex = queue.poll();

            for (int nextVertex : adjMap.get(vertex))
            {
                if (nextVertex == destination) return true;
                if (visited.contains(nextVertex)) continue;

                visited.add(nextVertex);
                queue.offer(nextVertex);
            }
        }

        return false;

    }
}