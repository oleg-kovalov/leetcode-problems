class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    
        int[] colors = new int[n + 1]; 
        Arrays.fill(colors, 0);

        int totalGroups = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            List<Integer> component = new ArrayList<>();
            if (!isBipartite(i, graph, colors, visited, component)) {
                return -1; 
            }

            int maxGroups = findMaxGroups(component, graph);
            totalGroups += maxGroups;
        }

        return totalGroups;
    }

    private boolean isBipartite(int start, List<List<Integer>> graph, int[] colors, boolean[] visited, List<Integer> component) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1; 
        visited[start] = true;

        while (queue.size() > 0) {
            int node = queue.poll();
            component.add(node);

            for (int neighbor: graph.get(node)) {
                if (colors[neighbor] == 0) { 
                    colors[neighbor] = -colors[node]; 
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false; 
                }
            }
        }
        return true;
    }
    private int findMaxGroups(List<Integer> component, List<List<Integer>> graph) {
        int maxGroups = 0;

        for (int node: component) {
            maxGroups = Math.max(maxGroups, bfsDepth(node, graph));
        }

        return maxGroups;
    }
    private int bfsDepth(int start, List<List<Integer>> graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        queue.offer(start);
        depth.put(start, 1);

        int maxDepth = 1;
        while (queue.size() > 0) {
            int node = queue.poll();
            int currentDepth = depth.get(node);

            for (int neighbor: graph.get(node)) {
                if (!depth.containsKey(neighbor)) {
                    depth.put(neighbor, currentDepth + 1);
                    maxDepth = Math.max(maxDepth, currentDepth + 1);
                    queue.offer(neighbor);
                }
            }
        }
        return maxDepth;
    }
}