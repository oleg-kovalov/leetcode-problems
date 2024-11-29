class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {

        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            nodes.put(i, new HashSet<>());
        }

        for (int[] edge: edges)
        {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.push(0);

        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        int cycleNode = findCycle(0, -1, nodes, path, seen);
        Set<Integer> cycle = new HashSet<>();
        cycle.add(cycleNode);
        while (path.peek() != cycleNode)
        {
            cycle.add(path.pop());
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        LinkedList<int[]> queue = new LinkedList<>();
        for (int elem : cycle)
        {
            result[elem] = 0;
            for (int child: nodes.get(elem))
            {
                if (cycle.contains(child)) continue;
                queue.offer(new int[] {child, elem});
            }
        }

        while (queue.size() > 0)
        {
            int[] elem = queue.poll();
            int curr = elem[0];
            int parent = elem[1];
            result[curr] = result[parent] + 1;

            for (int child : nodes.get(curr))
            {
                if (child == parent) continue;
                queue.offer(new int[] {child, curr});
            }
        }


        return result;

    }

    private int findCycle(int node, int parent, Map<Integer, Set<Integer>> nodes, LinkedList<Integer> path, Set<Integer> seen)
    {
        for (int child: nodes.get(node))
        {
            if (child == parent) continue; // don't return to parent

            if (seen.contains(child)) return child; // found a cycle

            seen.add(child);
            path.push(child);

            int res = findCycle(child, node, nodes, path, seen);
            if (res >= 0) return res;

            seen.remove(child);
            path.pop();
        }

        return -1;
    }
}