class Solution {
    LinkedHashSet<Integer> path;
    public int[] findRedundantConnection(int[][] edges) {
        path = new LinkedHashSet<>();

        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int[] edge: edges)
        {
            edgesMap.putIfAbsent(edge[0], new ArrayList<>());
            edgesMap.get(edge[0]).add(edge[1]);

            edgesMap.putIfAbsent(edge[1], new ArrayList<>());
            edgesMap.get(edge[1]).add(edge[0]);
        }

        boolean cycleFound = dfs(1, -1, edgesMap);
        System.out.println(path);
        if (!cycleFound) return new int[0];

        for (int i=edges.length-1; i>=0; i--)
        {
            if (path.contains(edges[i][0]) && path.contains(edges[i][1])) return edges[i];
        }

        return new int[0];

    }

    private boolean dfs (int node, int parent, Map<Integer, List<Integer>> edgesMap)
    {
        if (path.contains(node)) {
            // cycle detected;
            HashSet<Integer> nonCycle = new HashSet<>();
            //keep only cycle nodes
            Iterator<Integer> iterator = path.iterator();
            while(iterator.hasNext())
            {
                int n = iterator.next();
                if (n == node) break;
                nonCycle.add(n);
            }
            path.removeAll(nonCycle);
            return true;
        }

        path.add(node);

        List<Integer> children = edgesMap.getOrDefault(node, Collections.emptyList());
        for (int child: children)
        {
            if (child == parent) continue;

            if (dfs(child, node, edgesMap)) return true;
        }

        path.remove(node);
        return false;
    }
}