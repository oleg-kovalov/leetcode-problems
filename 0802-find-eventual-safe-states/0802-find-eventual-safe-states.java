class Solution {
    Set<Integer> good = new HashSet<>();
    Set<Integer> bad = new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        for (int i=0; i<graph.length; i++)
        {
            dfs(i, graph, new HashSet<>());
        }

        List<Integer> result = new ArrayList<>(good);
        Collections.sort(result);

        return result;
    }

    private void dfs(int curr, int[][] graph, Set<Integer> path)
    {
        if (path.contains(curr) || bad.contains(curr))
        {
            bad.addAll(path);
            return;
        }

        if (good.contains(curr)) return;


        path.add(curr);
        for (int child: graph[curr])
        {
            dfs(child, graph, path);
        }
        path.remove(curr);

        if (!bad.contains(curr))
        {
            good.add(curr);
        }
    }


}