class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] edge: edges)
        {
            adjMap.putIfAbsent(edge[0], new ArrayList<>());
            adjMap.get(edge[0]).add(edge[1]);
            inDegree[edge[0]] += 1;

            adjMap.putIfAbsent(edge[1], new ArrayList<>());
            adjMap.get(edge[1]).add(edge[0]);
            inDegree[edge[1]] += 1;
        }

        // System.out.println(Arrays.toString(inDegree));       

        int[] depths = new int[n];
        Set<Integer> visited = new HashSet<>();

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<inDegree.length; i++)
        {
            if (inDegree[i] != 1) continue;

            inDegree[i] -= 1;
            visited.add(i);
            queue.offer(i);
        }



        while (queue.size() > 0)
        {
            int vertex = queue.poll();

            for (int nextVertex: adjMap.get(vertex))
            {
                if (visited.contains(nextVertex)) continue;
                
                inDegree[nextVertex] -= 1;
                if (inDegree[nextVertex] == 1)
                {
                    depths[nextVertex] = Math.max(depths[nextVertex], depths[vertex] + 1);
                    visited.add(nextVertex);
                    queue.offer(nextVertex);
                }
            }
        }

        // System.out.println(Arrays.toString(inDegree));       
        // System.out.println(Arrays.toString(depths));


        List<Integer> result = new ArrayList<>();
        int maxDepth = -1;
        for (int i=0; i<depths.length; i++)
        {
            int depth = depths[i];
            if (depth < maxDepth) {
                continue;
            } else if (depth == maxDepth)
            {
                result.add(i);
            } else {
                maxDepth = depth;
                result = new ArrayList<>();
                result.add(i);
            }
        }

        return result;
    }
}