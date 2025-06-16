class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int count = n;

        DSU dsu = new DSU(n);

        for (int[] edge: edges)
        {
            if (dsu.join(edge[0], edge[1])) 
            {
                count -= 1;
            }
        }

        return count;
    }

    class DSU
    {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> ranks = new HashMap<>();

        public DSU (int n)
        {
            for (int i=0; i<n; i++)
            {
                parents.put(i, i);
                ranks.put(i, 1);
            }
        }

        public int find(int node)
        {
            if (parents.get(node) == node) return node;

            int root = find(parents.get(node));
            parents.put(node, root);

            return root;
        }

        public boolean join (int nodeA, int nodeB)
        {
            int parentA = find(nodeA);
            int parentB = find(nodeB);

            if (parentA == parentB) return false; // cycle

            int rankA = ranks.get(parentA);
            int rankB = ranks.get(parentB);

            if (rankA < rankB)
            {
                parents.put(parentA, parentB);
            } else if (rankA > rankB)
            {
                parents.put(parentB, parentA);
            } else {
                parents.put(parentB, parentA);
                ranks.put(parentA, rankA + 1);
            }

            return true;
        }

    }
}